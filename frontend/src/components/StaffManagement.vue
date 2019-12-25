<template>
    <el-container>
        <el-header style="margin-top: 25px; text-align: left">
            <el-input
                    placeholder="请输入要搜索的人员姓名或人员所在企业名称"
                    v-model="staffToSearch.name" style="width: 350px; margin-right: 15px">
            </el-input>
            <el-button type="info" size="medium" style="margin-left: 15px" @click="search_direct">按人名搜</el-button>
            <el-button type="info" size="medium" style="margin-left: 15px" @click="search_by_enterprise">按企业搜
            </el-button>
        </el-header>

        <el-main class="with_shadow">
            <el-table
                    ref="multipleTable"
                    :data="staff"
                    tooltip-effect="dark"
                    style="width: 100%;"
                    max-height="510">

                <el-table-column
                        prop="staffId"
                        label="人员id"
                        width="90"
                        align="left">
                </el-table-column>

                <el-table-column
                        prop="staffName"
                        label="人员姓名"
                        width="90"
                        align="left">
                </el-table-column>

                <el-table-column
                        prop="enterpriseName"
                        label="相关企业名称"
                        align="left">
                </el-table-column>

                <el-table-column
                        prop="owningEnterpriseNumber"
                        label="拥有公司数目"
                        align="left">
                </el-table-column>

                <el-table-column
                        prop="position"
                        label="职位"
                        align="left">
                </el-table-column>

                <el-table-column label="操作" width="220" align="left">
                    <template slot-scope="scope">
                        <el-button size="small" type="danger" icon="el-icon-delete"
                                   @click="delete_staff_dialog(scope.row)">
                        </el-button>
                        <el-button size="small" type="warning" icon="el-icon-edit"
                                   @click="modify_staff_dialog(scope.row)">
                        </el-button>
                    </template>
                </el-table-column>

            </el-table>
        </el-main>

        <el-dialog title="删除后不可恢复，确定要删除吗？" :visible.sync="dialogDeleteConfirmVisible">
            <el-button type="warning" @click="delete_staff">确 定</el-button>
            <el-button type="info" @click="dialogDeleteConfirmVisible = false">取 消</el-button>
        </el-dialog>

        <el-dialog title="修改信息" :visible.sync="dialogModifyVisible">
            <el-form>
                <el-form-item label="相关企业信息不可修改"></el-form-item>
                <el-form-item label="姓名:">
                    <el-input
                            placeholder="请输入姓名"
                            v-model="staffToModify.staffName">
                    </el-input>
                </el-form-item>
                <el-form-item label="拥有公司数目:">
                    <el-input
                            placeholder="请输入拥有公司数目"
                            v-model="staffToModify.owningEnterpriseNumber">
                    </el-input>
                </el-form-item>
                <el-form-item label="职位:">
                    <el-input
                            placeholder="请输入职位"
                            v-model="staffToModify.position">
                    </el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="warning" @click="modify_staff">确 定</el-button>
                <el-button type="info" @click="dialogModifyVisible = false">取 消</el-button>
            </div>
        </el-dialog>

    </el-container>
</template>

<script>
    export default {
        name: "StaffSearch",
        data() {
            return {
                staff: [],
                dialogDeleteConfirmVisible: false,
                dialogModifyVisible: false,
                staffToSearch: {
                    name: '',
                    by_name: false,
                },
                originalStaff: {
                    staffId: '',
                    enterpriseId: 0,
                    staffName: '',
                    position: '',
                },
                staffToModify: {
                    staffId: '',
                    staffName: '',
                    owningEnterpriseNumber: 0,
                    position: '',
                },
            }
        },
        methods: {
            search_direct() {
                if (this.staffToSearch.name === '') {
                    this.$message({type: 'error', message: '请先输入'});
                    return;
                }
                this.staffToSearch.by_name = true;
                let _this = this;
                this.getRequest("/staff/name/" + _this.staffToSearch.name).then(resp => {
                    if (resp && resp.status === 200) {
                        if (resp.data.length === 0) {
                            _this.staff = [];
                            _this.$message({type: 'error', message: '没有结果'});
                        } else if (resp.data.length < 999) {
                            _this.staff = resp.data;
                        } else {
                            _this.staff = [];
                            _this.$message({type: 'error', message: '搜索目标过于泛化 请尝试更精确的搜索'});
                        }

                    }
                });
            },
            search_by_enterprise() {
                if (this.staffToSearch.name === '') {
                    this.$message({type: 'error', message: '请先输入'});
                    return;
                }
                this.staffToSearch.by_name = false;
                let _this = this;
                this.getRequest("/staff/enterprise/" + _this.staffToSearch.name).then(resp => {
                    if (resp && resp.status === 200) {
                        if (resp.data.length === 0) {
                            _this.staff = [];
                            _this.$message({type: 'error', message: '没有结果'});
                        } else if (resp.data.length < 1999) {
                            _this.staff = resp.data;
                        } else {
                            _this.staff = [];
                            _this.$message({type: 'error', message: '搜索目标过于泛化 请尝试更精确的搜索'});
                        }
                    }
                });
            },
            delete_staff_dialog(row) {
                this.originalStaff.staffId = row.staffId;
                this.dialogDeleteConfirmVisible = true;
            },
            delete_staff() {
                let _this = this;
                this.postRequest("/staff/delete", {"staffId": _this.originalStaff.staffId}).then(resp => {
                    if (resp && resp.status === 200) {
                        if (this.staffToSearch.by_name === true) {
                            _this.search_direct();
                        } else {
                            _this.search_by_enterprise();
                        }
                        _this.dialogDeleteConfirmVisible = false;
                        _this.$message({type: 'success', message: '删除成功'});
                    } else {
                        _this.dialogDeleteConfirmVisible = false;
                        _this.$message({type: 'error', message: '删除失败'});
                    }
                });
            },
            modify_staff_dialog(row) {
                this.originalStaff.staffId = row.staffId;
                this.originalStaff.enterpriseId = row.enterpriseId;
                this.originalStaff.staffName = row.staffName;
                this.originalStaff.position = row.position;
                this.staffToModify.staffId = row.staffId;
                this.staffToModify.staffName = row.staffName;
                this.staffToModify.owningEnterpriseNumber = row.owningEnterpriseNumber;
                this.staffToModify.position = row.position;
                this.dialogModifyVisible = true;
            },
            modify_staff() {
                let _this = this;
                this.postRequest("/staff/modify", {
                    "staffId": _this.staffToModify.staffId,
                    "staffName": _this.staffToModify.staffName,
                    "owningEnterpriseNumber": _this.staffToModify.owningEnterpriseNumber,
                    "position": _this.staffToModify.position
                }).then(resp => {
                    if (resp && resp.status === 200) {
                        if (this.staffToSearch.by_name === true) {
                            _this.search_direct();
                        } else {
                            _this.search_by_enterprise();
                        }
                        _this.dialogModifyVisible = false;
                        _this.$message({type: 'success', message: '修改成功'});
                    } else {
                        _this.dialogModifyVisible = false;
                        _this.$message({type: 'error', message: '修改失败'});
                    }
                });
            },
        },
    }
</script>

<style scoped>

</style>
