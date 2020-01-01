<template>
    <el-container>

        <el-main class="with_shadow">
            <el-table
                    ref="multipleTable"
                    :data="industries"
                    tooltip-effect="dark"
                    style="width: 100%;"
                    max-height="510">

                <el-table-column
                        label="行业"
                        align="left">
                    <template slot-scope="scope"><span style="color: #409eff;cursor: pointer"
                                                       @click="itemClick(scope.row)">{{ scope.row.industryName}}</span>
                    </template>
                </el-table-column>

                <el-table-column
                        prop="enterpriseCount"
                        label="企业数量"
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
                industries: [],
            }
        },
        methods: {
            load_industry() {
                let _this = this;
                this.getRequest("/industry/all").then(resp => {
                    if (resp && resp.status === 200) {
                        _this.industries = resp.data;
                    }
                });
            },
            itemClick (row) {

            },

        },
        mounted: function () {
            this.load_industry();
        },
    }
</script>

<style scoped>

</style>
