<template>
    <el-container>
        <el-header style="margin-top: 25px; text-align: left">
            <el-input
                    placeholder="请输入要搜索的公司名称"
                    v-model="enterpriseToSearch.name" style="width: 200px; margin-right: 15px">
            </el-input>
            <el-button type="info" size="medium" style="margin-left: 15px" @click="search_direct">精确搜索</el-button>
            <el-button type="info" size="medium" style="margin-left: 15px" @click="search_fuzzy">模糊搜索</el-button>
            <el-button type="primary" size="medium" style="margin-left: 15px" @click="showAdvancedSearchDialog=true">
                高级搜索
            </el-button>
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

        <el-dialog title="高级搜索" :visible.sync="showAdvancedSearchDialog">
            <el-form :model="form">
                <el-form-item label="企业id:" :label-width="formLabelWidth">
                    <el-input v-model="advancedSearchDialogForm.enterpriseId" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="企业名称:" :label-width="formLabelWidth">
                    <el-input v-model="advancedSearchDialogForm.enterpriseName" autocomplete="off"
                              placeholder="请输入内容"></el-input>
                </el-form-item>
                <el-form-item label="所在行业:" :label-width="formLabelWidth">
                    <el-autocomplete
                            style="width: 500px;"
                            v-model="advancedSearchDialogForm.industry"
                            :fetch-suggestions="queryIndustries"
                            placeholder="请输入内容">
                    </el-autocomplete>
                </el-form-item>
                <el-form-item label="企业类型:" :label-width="formLabelWidth">
                    <el-autocomplete
                            style="width: 500px;"
                            v-model="advancedSearchDialogForm.formOfBusinessEnterprise"
                            :fetch-suggestions="queryForms"
                            placeholder="请输入内容">
                    </el-autocomplete>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button type="primary" @click="search_advanced()">搜索</el-button>
            </div>
        </el-dialog>
    </el-container>
</template>

<script>
    export default {
        name: "EnterpriseSearch",
        data() {
            return {
                sss: '',
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
                enterpriseToSearch: {
                    name: ''
                },
                showAdvancedSearchDialog: false,
                advancedSearchDialogForm: {
                    enterpriseId: 0,
                    enterpriseName: '',
                    formOfBusinessEnterprise: '',
                    industry: '',
                }
            }
        },
        methods: {
            search_direct() {
                if (this.enterpriseToSearch.name === '') {
                    this.$message({type: 'error', message: '请先输入'});
                    return;
                }
                let _this = this;
                this.getRequest("/enterprise/name/" + _this.enterpriseToSearch.name).then(resp => {
                    if (resp && resp.status === 200) {
                        if (resp.data.length === 0) {
                            _this.enterprises = [];
                            _this.$message({type: 'error', message: '没有结果'});
                        } else if (resp.data.length < 999) {
                            _this.enterprises = resp.data;
                        } else {
                            _this.enterprises = [];
                            _this.$message({type: 'error', message: '搜索目标过于泛化 请尝试更精确的搜索'});
                        }

                    }
                });
            },
            search_fuzzy() {
                if (this.enterpriseToSearch.name === '') {
                    this.$message({type: 'error', message: '请先输入'});
                    return;
                }
                let _this = this;
                this.getRequest("/enterprise/name/es/" + _this.enterpriseToSearch.name).then(resp => {
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
            search_advanced() {
                let _this = this;
                let tmp_headers = '?';
                tmp_headers += 'enterpriseId=' + _this.advancedSearchDialogForm.enterpriseId;
                tmp_headers += '&enterpriseName=' + _this.advancedSearchDialogForm.enterpriseName;
                tmp_headers += '&form=' + _this.advancedSearchDialogForm.formOfBusinessEnterprise;
                tmp_headers += '&industry=' + _this.advancedSearchDialogForm.industry;
                this.getRequest("/enterprise/advanced" + tmp_headers).then(resp => {
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
                this.advancedSearchDialogForm.enterpriseId = 0;
                this.advancedSearchDialogForm.enterpriseName = '';
                this.advancedSearchDialogForm.formOfBusinessEnterprise = '';
                this.advancedSearchDialogForm.industry = '';
                this.showAdvancedSearchDialog = false;
            },
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
            loadIndustryAndForm() {
                let _this = this;
                this.getRequest("/industry/all").then(resp => {
                    if (resp && resp.status === 200) {
                        _this.industriesAll = resp.data;
                        _this.industriesAll = _this.industriesAll.map((industry => {
                            return {"value": industry.industryName};
                        }));
                    }
                });
                this.getRequest("/enterprise/form/all").then(resp => {
                    if (resp && resp.status === 200) {
                        _this.formOfBusinessEnterpriseAll = resp.data;
                        _this.formOfBusinessEnterpriseAll = _this.formOfBusinessEnterpriseAll.map((item => {
                            return {"value": item};
                        }));
                    }
                });
            },
            queryIndustries(queryString, cb) {
                let industriesAll = this.industriesAll;
                let results = queryString ? industriesAll.filter(this.createFilter(queryString)) : industriesAll;
                // 调用 callback 返回建议列表的数据
                cb(results);
            },
            queryForms(queryString, cb) {
                let formOfBusinessEnterpriseAll = this.formOfBusinessEnterpriseAll;
                let results = queryString ? formOfBusinessEnterpriseAll.filter(this.createFilter(queryString))
                    : formOfBusinessEnterpriseAll;
                // 调用 callback 返回建议列表的数据
                cb(results);
            },
            createFilter(queryString) {
                return (item) => {
                    return (item.value.indexOf(queryString) === 0);
                };
            },
        },
        mounted: function () {
            this.loadIndustryAndForm();
        },
    }
</script>

<style scoped>
    .el-input {
        width: 500px;
    }
</style>
