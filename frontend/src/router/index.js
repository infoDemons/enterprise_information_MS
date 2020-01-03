import Vue from 'vue'
import Router from 'vue-router'
import Value from '@/components/Value'
import Home from '@/components/Home'
import IndustrySearch from "@/components/IndustrySearch";
import EnterpriseSearch from '@/components/EnterpriseSearch'
import StaffSearch from '@/components/StaffSearch'
import StaffManagement from "../components/StaffManagement";
import EnterpriseManagement from "@/components/EnterpriseManagement";
import EnterprisePopularity from "@/components/EnterprisePopularity";
import TrademarkSearch from "@/components/TrademarkSearch";
import TrademarkManagement from "@/components/TrademarkManagement";
import EnterpriseChangeSearch from "@/components/EnterpriseChangeSearch";
import EnterpriseChangeManagement from "@/components/EnterpriseChangeManagement";
import Login from "@/components/Login";

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/login',
            name: '',
            component: Login,
            hidden: true,
        },
        {

            path: '/home',
            name: '',
            component: Home,
            hidden: true,
            children: [
                {
                    path: 'value',
                    name: '价值观管理',
                    component: Value,
                    meta: {
                        keepAlive: true
                    }
                },
                {
                    path: 'enterprise_search',
                    name: '搜索企业',
                    component: EnterpriseSearch,
                    meta: {
                        keepAlive: true
                    }
                },
                {
                    path: 'enterprise_management',
                    name: '管理企业',
                    component: EnterpriseManagement,
                    meta: {
                        keepAlive: true
                    }
                },
                {
                    path: 'enterprise_popularity',
                    name: '热度企业',
                    component: EnterprisePopularity,
                    meta: {
                        keepAlive: true
                    }
                },
                {
                    path: 'staff_search',
                    name: '搜索人员',
                    component: StaffSearch,
                    meta: {
                        keepAlive: true
                    }
                },
                {
                    path: 'staff_management',
                    name: '管理人员',
                    component: StaffManagement,
                    meta: {
                        keepAlive: true
                    }
                },
                {
                    path: 'industry_search',
                    name: '综合查询',
                    component: IndustrySearch,
                    meta: {
                        keepAlive: true
                    }
                },
                {
                    path: 'trademark_search',
                    name: '商标查询',
                    component: TrademarkSearch,
                    meta: {
                        keepAlive: true
                    }
                },
                {
                    path: 'trademark_management',
                    name: '商标管理',
                    component: TrademarkManagement,
                    meta: {
                        keepAlive: true
                    }
                },
                {
                    path: 'change_search',
                    name: '查询变更信息',
                    component: EnterpriseChangeSearch,
                    meta: {
                        keepAlive: true
                    }
                },
                {
                    path: 'change_management',
                    name: '商标管理',
                    component: EnterpriseChangeManagement,
                    meta: {
                        keepAlive: true
                    }
                },
            ]
        }
    ]
})
