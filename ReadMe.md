###需求
1. 反编译
   * 将目标jar和依赖都反编译，然后复制到同一个目录下
   * 需要并发进行提高效率
2. 代码分析
    * 需要解析类、类注解、方法、方法注解、方法参数、方法参数的类型，方法参数的注解
3. 接口分析
   * 显示接口列表
   * 每个接口的url、参数、body结构、header
4. 接口翻译
   * burpsuite格式
   * postman格式
   * yaml格式

### 计划   
1. 迭代零
   * 完成需求调研
   * 组件选型
   * 架构设计   
2. 迭代一目标
   * 可以反编译
   * 可以获取接口列表
   * 接口列表导出到一个文件中
   * 尽力而为翻译body结构
3. 迭代二目标
   * body结构准确
   * 提高性能
4. 迭代三目标
   * 完成到接口翻译功能
5. 迭代四
   * 完成gui
