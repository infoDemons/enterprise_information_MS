<template>
    <el-container>
        <el-header style="margin-top: 25px; text-align: left">
            <el-input
                    placeholder="请输入要搜索的人员姓名或人员所在企业名称"
                    v-model="staffToSearch.name" style="width: 350px; margin-right: 15px">
            </el-input>
            <el-button type="info" size="medium" style="margin-left: 15px" @click="search_direct">按人名搜</el-button>
            <el-button type="info" size="medium" style="margin-left: 15px" @click="search_by_enterprise">按企业搜</el-button>
        </el-header>

        <el-main class="with_shadow">
            <el-table
                    ref="multipleTable"
                    :data="staff"
                    tooltip-effect="dark"
                    style="width: 100%;"
                    max-height="410">

                <el-table-column
                        prop="staffId"
                        label="人员id"
                        width="150"
                        align="left">
                </el-table-column>

                <el-table-column
                        prop="staffName"
                        label="人员姓名"
                        width="150"
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

            </el-table>
        </el-main>

    </el-container>
</template>

<script>
    export default {
        name: "StaffSearch",
        data() {
            return {
                staff: [],
                staffToSearch: {
                    name: '',
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
        },
    }
</script>

<style scoped>

</style>
