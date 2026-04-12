# 后端接口需求文档

## 1. 领养申请模块

### 1.1 提交领养申请
- **接口路径**: `/adoption/application/submit`
- **请求方法**: POST
- **请求参数**:
  - `housingType`: 住房类型 (owned/rented/dormitory)
  - `petAllowed`: 是否允许养宠 (是/否)
  - `hasEnclosedBalcony`: 是否有封闭阳台/纱窗 (是/否)
  - `familyAgree`: 家庭成员是否同意 (是/否)
  - `hasAllergy`: 有无过敏情况 (有/无)
  - `workSchedule`: 工作作息
  - `companionTime`: 每天陪伴时间 (less1/1-3/3-6/more6)
  - `knowBasicCost`: 是否了解基础开销 (是/否)
  - `canAffordMedical`: 是否能承担医疗费用 (是/否)
  - `scientificFeeding`: 是否接受科学喂养 (是/否)
  - `agreeSterilization`: 是否同意绝育/牵引 (是/否)
  - `petExperience`: 养宠经验
  - `futurePlans`: 未来计划
  - `noAbandon`: 是否承诺不随意弃养 (是/否)
  - `acceptVisit`: 是否接受回访 (是/否)
  - `applicantName`: 申请人姓名
  - `contactPhone`: 联系电话
  - `address`: 居住地址
  - `files`: 证明材料文件

### 1.2 下载领养协议模板
- **接口路径**: `/adoption/agreement/download`
- **请求方法**: GET
- **返回值**: 文件流

### 1.3 获取领养申请列表
- **接口路径**: `/adoption/application/list`
- **请求方法**: GET
- **请求参数**:
  - `status`: 申请状态 (pending/approved/rejected)
  - `applicantName`: 申请人姓名
  - `pageNum`: 页码
  - `pageSize`: 每页数量
- **返回值**:
  - `rows`: 申请列表
  - `total`: 总数量

### 1.4 获取领养申请详情
- **接口路径**: `/adoption/application/{id}`
- **请求方法**: GET
- **返回值**: 申请详情

### 1.5 审批领养申请
- **接口路径**: `/adoption/application/{id}/approve`
- **请求方法**: PUT
- **请求参数**:
  - `result`: 审批结果 (approved/rejected)
  - `comments`: 审批意见
  - `deposit`: 押金金额

### 1.6 上传签署后的协议
- **接口路径**: `/adoption/application/{id}/agreement`
- **请求方法**: POST
- **请求参数**:
  - `file`: 签署后的协议文件

## 2. 物资捐赠模块

### 2.1 提交物资捐赠申请
- **接口路径**: `/donation/application/submit`
- **请求方法**: POST
- **请求参数**:
  - `donorName`: 捐赠人姓名
  - `contactPhone`: 联系电话
  - `donationType`: 捐赠类型 (food/supplies/medicine/other)
  - `items`: 捐赠物品列表
    - `name`: 物品名称
    - `quantity`: 数量
    - `unit`: 单位
    - `description`: 描述
  - `donationMethod`: 捐赠方式 (现场捐赠/快递捐赠)
  - `donationAddress`: 捐赠地址 (现场捐赠时必填)
  - `shippingAddress`: 快递地址 (快递捐赠时必填)
  - `donationTime`: 捐赠时间
  - `remarks`: 备注

### 2.2 获取物资捐赠列表
- **接口路径**: `/donation/application/list`
- **请求方法**: GET
- **请求参数**:
  - `status`: 捐赠状态 (pending/confirmed/cancelled)
  - `donorName`: 捐赠人姓名
  - `donationType`: 捐赠类型
  - `pageNum`: 页码
  - `pageSize`: 每页数量
- **返回值**:
  - `rows`: 捐赠列表
  - `total`: 总数量

### 2.3 获取物资捐赠详情
- **接口路径**: `/donation/application/{id}`
- **请求方法**: GET
- **返回值**: 捐赠详情

### 2.4 确认收到捐赠
- **接口路径**: `/donation/application/{id}/confirm`
- **请求方法**: PUT

### 2.5 取消捐赠
- **接口路径**: `/donation/application/{id}/cancel`
- **请求方法**: PUT

## 3. 故事会模块

### 3.1 发布故事
- **接口路径**: `/story/publish`
- **请求方法**: POST
- **请求参数**:
  - `title`: 故事标题
  - `coverImage`: 封面图片
  - `content`: 故事内容
  - `author`: 作者

### 3.2 获取故事列表
- **接口路径**: `/story/list`
- **请求方法**: GET
- **请求参数**:
  - `title`: 故事标题
  - `author`: 作者
  - `pageNum`: 页码
  - `pageSize`: 每页数量
- **返回值**:
  - `rows`: 故事列表
  - `total`: 总数量

### 3.3 获取故事详情
- **接口路径**: `/story/{id}`
- **请求方法**: GET
- **返回值**: 故事详情

### 3.4 点赞故事
- **接口路径**: `/story/{id}/like`
- **请求方法**: POST

### 3.5 评论故事
- **接口路径**: `/story/{id}/comment`
- **请求方法**: POST
- **请求参数**:
  - `content`: 评论内容
  - `author`: 评论作者

### 3.6 获取故事评论列表
- **接口路径**: `/story/{id}/comments`
- **请求方法**: GET
- **请求参数**:
  - `pageNum`: 页码
  - `pageSize`: 每页数量
- **返回值**:
  - `rows`: 评论列表
  - `total`: 总数量

### 3.7 删除故事
- **接口路径**: `/story/{id}`
- **请求方法**: DELETE

## 4. 爱心交流社区模块

### 4.1 发布帖子
- **接口路径**: `/community/post/publish`
- **请求方法**: POST
- **请求参数**:
  - `title`: 帖子标题
  - `category`: 帖子分类 (experience/help/fun/other)
  - `content`: 帖子内容
  - `author`: 作者

### 4.2 获取帖子列表
- **接口路径**: `/community/post/list`
- **请求方法**: GET
- **请求参数**:
  - `title`: 帖子标题
  - `author`: 作者
  - `category`: 帖子分类
  - `pageNum`: 页码
  - `pageSize`: 每页数量
- **返回值**:
  - `rows`: 帖子列表
  - `total`: 总数量

### 4.3 获取帖子详情
- **接口路径**: `/community/post/{id}`
- **请求方法**: GET
- **返回值**: 帖子详情

### 4.4 点赞帖子
- **接口路径**: `/community/post/{id}/like`
- **请求方法**: POST

### 4.5 评论帖子
- **接口路径**: `/community/post/{id}/comment`
- **请求方法**: POST
- **请求参数**:
  - `content`: 评论内容
  - `author`: 评论作者

### 4.6 获取帖子评论列表
- **接口路径**: `/community/post/{id}/comments`
- **请求方法**: GET
- **请求参数**:
  - `pageNum`: 页码
  - `pageSize`: 每页数量
- **返回值**:
  - `rows`: 评论列表
  - `total`: 总数量

### 4.7 删除帖子
- **接口路径**: `/community/post/{id}`
- **请求方法**: DELETE

### 4.8 收藏帖子
- **接口路径**: `/community/post/{id}/collect`
- **请求方法**: POST

### 4.9 获取收藏列表
- **接口路径**: `/community/collection/list`
- **请求方法**: GET
- **请求参数**:
  - `pageNum`: 页码
  - `pageSize`: 每页数量
- **返回值**:
  - `rows`: 收藏列表
  - `total`: 总数量

## 5. 管理员端模块

### 5.1 志愿者管理

#### 5.1.1 获取志愿者列表
- **接口路径**: `/admin/volunteer/list`
- **请求方法**: GET
- **请求参数**:
  - `name`: 志愿者姓名
  - `status`: 状态 (pending/approved/rejected)
  - `pageNum`: 页码
  - `pageSize`: 每页数量
- **返回值**:
  - `rows`: 志愿者列表
  - `total`: 总数量

#### 5.1.2 获取志愿者详情
- **接口路径**: `/admin/volunteer/{id}`
- **请求方法**: GET
- **返回值**: 志愿者详情

#### 5.1.3 审核志愿者
- **接口路径**: `/admin/volunteer/{id}/approve`
- **请求方法**: PUT
- **请求参数**:
  - `result`: 审核结果 (approved/rejected)
  - `comments`: 审核意见

#### 5.1.4 添加志愿者
- **接口路径**: `/admin/volunteer`
- **请求方法**: POST
- **请求参数**:
  - `name`: 姓名
  - `phone`: 联系电话
  - `email`: 邮箱
  - `skills`: 技能特长
  - `status`: 状态

#### 5.1.5 更新志愿者信息
- **接口路径**: `/admin/volunteer/{id}`
- **请求方法**: PUT
- **请求参数**:
  - `name`: 姓名
  - `phone`: 联系电话
  - `email`: 邮箱
  - `skills`: 技能特长
  - `status`: 状态

#### 5.1.6 删除志愿者
- **接口路径**: `/admin/volunteer/{id}`
- **请求方法**: DELETE

### 5.2 合作机构管理

#### 5.2.1 获取合作机构列表
- **接口路径**: `/admin/organization/list`
- **请求方法**: GET
- **请求参数**:
  - `name`: 机构名称
  - `status`: 状态 (pending/approved/rejected)
  - `pageNum`: 页码
  - `pageSize`: 每页数量
- **返回值**:
  - `rows`: 机构列表
  - `total`: 总数量

#### 5.2.2 获取合作机构详情
- **接口路径**: `/admin/organization/{id}`
- **请求方法**: GET
- **返回值**: 机构详情

#### 5.2.3 审核合作机构
- **接口路径**: `/admin/organization/{id}/approve`
- **请求方法**: PUT
- **请求参数**:
  - `result`: 审核结果 (approved/rejected)
  - `comments`: 审核意见

#### 5.2.4 添加合作机构
- **接口路径**: `/admin/organization`
- **请求方法**: POST
- **请求参数**:
  - `name`: 机构名称
  - `contactPerson`: 联系人
  - `contactPhone`: 联系电话
  - `address`: 地址
  - `status`: 状态

#### 5.2.5 更新合作机构信息
- **接口路径**: `/admin/organization/{id}`
- **请求方法**: PUT
- **请求参数**:
  - `name`: 机构名称
  - `contactPerson`: 联系人
  - `contactPhone`: 联系电话
  - `address`: 地址
  - `status`: 状态

#### 5.2.6 删除合作机构
- **接口路径**: `/admin/organization/{id}`
- **请求方法**: DELETE