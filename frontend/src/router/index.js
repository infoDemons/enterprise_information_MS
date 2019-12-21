import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Value from '@/components/Value'
import Home from '@/components/Home'
import EnterpriseSearch from '@/components/EnterpriseSearch'
import StaffSearch from '@/components/StaffSearch'

Vue.use(Router);

export default new Router({
    routes: [
        {
            path: '/',
            name: '',
            component: HelloWorld,
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
                    path: 'staff_search',
                    name: '搜索人员',
                    component: StaffSearch,
                    meta: {
                        keepAlive: true
                    }
                },
            ]
        }
    ]
})
