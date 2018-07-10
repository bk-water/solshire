// 菜单配置
// headerMenuConfig：头部导航配置
// asideMenuConfig：侧边导航配置

const headerMenuConfig = [];

const asideMenuConfig = [
  {
    path: "/",
    name: "首页",
    icon: "el-icon-menu"
  },
  {
    name: "财富团队成员",
    icon: "el-icon-date",
    path: "",
    children: [
      {
        path: "/partner/list",
        name: "事业合伙人管理"
      },
      {
        path: "/adviser/list",
        name: "顾问管理"
      }
    ]
  },
  // {
  //   name: "销售管理",
  //   icon: "el-icon-edit-outline",
  //   children: [
  //     {
  //       path: "/customer/list",
  //       name: "客户管理"
  //     },
  //     {
  //       path: "/policy/list",
  //       name: "保单管理"
  //     }
  //   ]
  // },
  // {
  //   name: "佣金结算",
  //   icon: "el-icon-picture-outline",
  //   children: [
  //     {
  //       path: "/line",
  //       name: "业绩酬金"
  //     },
  //     {
  //       path: "/histogram",
  //       name: "产品佣金"
  //     },
  //     {
  //       path: "/bar",
  //       name: "酬金发放"
  //     },{
  //       path:'',
  //       name:'酬金发放日志'
  //     }
  //   ]
  // },
  // {
  //   path: "/profile",
  //   name: "详情页",
  //   icon: "el-icon-tickets",
  //   children: [
  //     {
  //       path: "/success",
  //       name: "基础详情页"
  //     },
  //     {
  //       path: "/fail",
  //       name: "失败"
  //     }
  //   ]
  // },
  {
    path: "/article/list",
    name: "网站编辑",
    icon: "el-icon-circle-check-outline"
  }
];

export { headerMenuConfig, asideMenuConfig };
