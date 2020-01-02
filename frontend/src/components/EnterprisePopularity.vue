<template>
    <el-container>
        <el-header style="margin-top: 25px; text-align: left">
        </el-header>

        <el-main class="with_shadow">
            <el-table
                    ref="multipleTable"
                    :data="enterprises"
                    tooltip-effect="dark"
                    style="width: 100%;"
                    max-height="510">

                <el-table-column
                        prop="enterpriseId"
                        label="企业id"
                        width="100"
                        align="left">
                </el-table-column>

                <el-table-column
                        label="企业名称"
                        align="left">
                    <template slot-scope="scope"><span style="color: #409eff;cursor: pointer"
                                                       @click="itemClick(scope.row)">{{ scope.row.enterpriseName}}</span>
                    </template>
                </el-table-column>

                <el-table-column
                        prop="industry"
                        label="所在行业"
                        align="left">
                </el-table-column>

            </el-table>
        </el-main>

        <el-dialog title="企业详情" :visible.sync="dialogFormVisible">
            <el-form :model="form">
                <el-form-item label="企业id:" :label-width="formLabelWidth">
                    <el-input v-model="form.enterpriseId" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="企业名称:" :label-width="formLabelWidth">
                    <el-input v-model="form.enterpriseName" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="注册资本:" :label-width="formLabelWidth">
                    <el-input v-model="form.registeredCapital" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="已缴资本:" :label-width="formLabelWidth">
                    <el-input v-model="form.paidInCapital" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="所在行业:" :label-width="formLabelWidth">
                    <el-input v-model="form.industry" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="法定代表人:" :label-width="formLabelWidth">
                    <el-input v-model="form.legalRepresentative" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="经营范围:" :label-width="formLabelWidth">
                    <el-input v-model="form.businessScope" autocomplete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="dialogFormVisible = false">确定</el-button>
            </div>
        </el-dialog>

    </el-container>
</template>

<script>
    export default {
        name: "EnterprisePopularity",
        data() {
            return {
                industriesAll: [],
                formOfBusinessEnterpriseAll: [],
                enterprises: [],
                dialogFormVisible: false,
                form: {
                    enterpriseId: 0,
                    enterpriseName: '',
                    explanation: '',
                    registeredCapital: '',
                    paidInCapital: '',
                    industry: '',
                    businessScope: '',
                    legalRepresentative: '',
                },
                formLabelWidth: '120px',
            }
        },
        methods: {
            itemClick(row) {
                this.form.enterpriseId = row.enterpriseId;
                this.form.enterpriseName = row.enterpriseName;
                this.form.registeredCapital = row.registeredCapital;
                this.form.paidInCapital = row.paidInCapital;
                this.form.industry = row.industry;
                this.form.businessScope = row.businessScope;
                this.form.legalRepresentative = row.legalRepresentative;
                this.dialogFormVisible = true;
            },
            loadMostPopularEnterprise() {
                let _this = this;
                this.getRequest("/enterprise/popularity").then(resp => {
                    if (resp && resp.status === 200) {
                        if (resp.data.length === 0) {
                            _this.enterprises = [];
                            _this.$message({type: 'error', message: '没有结果'});
                        } else if (resp.data.length < 1999) {
                            _this.enterprises = resp.data;
                        } else {
                            _this.enterprises = [];
                            _this.$message({type: 'error', message: '搜索目标过于泛化 请尝试更精确的搜索'});
                        }
                    }
                });
            },
        },
        mounted: function () {
            this.loadMostPopularEnterprise();
        },
    }
</script>

<style scoped>
    .el-input {
        width: 500px;
    }
</style>



