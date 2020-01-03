<template>
    <el-container>
        <el-header style="margin-top: 25px; text-align: left">
            <el-input
                    placeholder="请输入要查询变更信息的企业名称"
                    v-model="enterpriseChangeToSearch.name" style="width: 350px; margin-right: 15px">
            </el-input>
            <el-button type="info" size="medium" style="margin-left: 15px" @click="search_direct">按企业搜索</el-button>
        </el-header>

        <el-main class="with_shadow">
            <el-table
                    ref="multipleTable"
                    :data="enterpriseChange"
                    tooltip-effect="dark"
                    style="width: 100%;"
                    max-height="510">

                <el-table-column
                        prop="enterpriseInformationChangeId"
                        label="变更信息id"
                        width="100"
                        align="left">
                </el-table-column>

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
                        prop="informationChangeDate"
                        label="变更日期"
                        align="left">
                </el-table-column>

                <el-table-column
                        prop="informationChangeType"
                        label="变更项目"
                        align="left">
                </el-table-column>

                <el-table-column
                        prop="informationBefore"
                        label="变更前"
                        align="left">
                </el-table-column>

                <el-table-column
                        prop="informationAfter"
                        label="变更后"
                        align="left">
                </el-table-column>

                <el-table-column
                        prop="createDate"
                        label="创建日期"
                        align="left">
                </el-table-column>

            </el-table>
        </el-main>

    </el-container>
</template>

<script>
    export default {
        name: "EnterpriseChangeSearch",
        data() {
            return {
                enterpriseChange: [],
                enterpriseChangeToSearch: {
                    name: '',
                },
            }
        },
        methods: {
            search_direct() {
                if (this.enterpriseChangeToSearch.name === '') {
                    this.$message({type: 'error', message: '请先输入'});
                    return;
                }
                let _this = this;
                this.getRequest("/change/enterprise_name/" + _this.enterpriseChangeToSearch.name).then(resp => {
                    if (resp && resp.status === 200) {
                        if (resp.data.length === 0) {
                            _this.enterpriseChange = [];
                            _this.$message({type: 'error', message: '没有结果'});
                        } else if (resp.data.length < 999) {
                            _this.enterpriseChange = resp.data;
                        } else {
                            _this.enterpriseChange = [];
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
