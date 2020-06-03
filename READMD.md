# 仿照百度搜索项目
> 版本1 工具：mysql redis SpringBoot vue ElementUI，简单实现百度搜索页面展示
> 之后版本可能会使用es 进行改进
### 前端展示
![img](imgs\1.png)

### 登录
![img](imgs\2.png)
![img](imgs\3.png)
> 尚未与后台交互，只是前端上的效果展示

### 搜索建言
![img](imgs\4.png)
> 简单的实现，通过后台查询数据库，这里使用redis减缓数据库压力，建言方式使用stream+文字匹配，所以可以单个字或者单个词匹配

### 搜索内容
![img](imgs\5.png)
> 简单完成样式，实现关键字高亮，这里只是查询mysql数据库和对文章的简单处理，暂时未添加其他操作