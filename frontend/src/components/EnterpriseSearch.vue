<template>
    <el-container>
        <el-header style="margin-top: 25px; text-align: left">
            <el-input
                    placeholder="请输入要搜索的公司名称"
                    v-model="enterpriseToSearch.name" style="width: 200px; margin-right: 15px">
            </el-input>
            <el-button type="info" size="medium" style="margin-left: 15px" @click="search">搜索公司</el-button>
        </el-header>

        <el-main class="with_shadow">
            <el-table
                    ref="multipleTable"
                    :data="enterprises"
                    tooltip-effect="dark"
                    style="width: 100%;"
                    max-height="410">

                <el-table-column
                        prop="enterpriseId"
                        label="企业id"
                        width="100"
                        align="left">
                </el-table-column>

                <el-table-column
                        prop="enterpriseName"
                        label="企业名称"
                        align="left">
                </el-table-column>

                <el-table-column
                        prop="industry"
                        label="所在行业"
                        align="left">
                </el-table-column>


            </el-table>
        </el-main>

        <el-dialog title="编辑价值观信息" :visible.sync="dialogFormVisible">
            <el-form :model="form">
                <el-form-item label="请输入新名称:" :label-width="formLabelWidth">
                    <el-input v-model="form.name" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="请输入新描述:" :label-width="formLabelWidth">
                    <el-input v-model="form.explanation" autocomplete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取消</el-button>
                <el-button type="primary" @click="doEdit()">确定
                </el-button>
            </div>
        </el-dialog>
    </el-container>
</template>

<script>
    export default {
        name: "EnterpriseSearch",
        data() {
            return {
                enterprises: [],
                dialogFormVisible: false,
                form: {
                    id: 0,
                    name: '',
                    explanation: '',
                },
                formLabelWidth: '120px',
                enterpriseToSearch: {
                    name: ''
                }
            }
        },
        methods: {
            search() {
                let _this = this;
                this.getRequest("/enterprise/name/" + _this.enterpriseToSearch.name).then(resp => {
                    if (resp && resp.status === 200) {
                        _this.enterprises = resp.data;
                    }
                });
            },
        },
    }
</script>

<style scoped>

</style>
