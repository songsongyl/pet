CREATE TABLE `sys_user` (
                            `user_id` INT NOT NULL AUTO_INCREMENT COMMENT '用户ID（主键）',
                            `username` VARCHAR(50) NOT NULL COMMENT '用户名（登录账号）',
                            `password` VARCHAR(100) NOT NULL COMMENT '加密密码（MD5/BCrypt）',
                            `real_name` VARCHAR(50) DEFAULT '' COMMENT '真实姓名',
                            `phone` VARCHAR(20) DEFAULT '' COMMENT '联系电话',
                            `email` VARCHAR(100) DEFAULT '' COMMENT '邮箱',
                            `id_card` VARCHAR(20) DEFAULT '' COMMENT '身份证号（领养/志愿者认证用）',
                            `user_type` TINYINT NOT NULL COMMENT '用户类型：1-普通用户，2-救助者，3-领养者，4-志愿者，5-合作机构，6-管理员',
                            `status` TINYINT NOT NULL DEFAULT 1 COMMENT '账号状态：0-禁用，1-正常，2-冻结',
                            `address` VARCHAR(255) DEFAULT '' COMMENT '居住地址（领养审核用）',
                            `living_area` DECIMAL(10,2) DEFAULT 0 COMMENT '居住面积（㎡，领养审核用）',
                            `has_pet_exp` TINYINT DEFAULT 0 COMMENT '是否有养宠经验：0-无，1-有',
                            `love_points` INT DEFAULT 0 COMMENT '爱心积分',
                            `user_level` TINYINT DEFAULT 1 COMMENT '用户等级：1-初心，2-暖心，3-爱心，4-公益，5-守护',
                            `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                            `last_login_time` DATETIME DEFAULT NULL COMMENT '最后登录时间',
                            `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                            PRIMARY KEY (`user_id`),
                            UNIQUE KEY `uk_username` (`username`),
                            INDEX `idx_user_type` (`user_type`),
                            INDEX `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表（存储所有角色基础信息）';




CREATE TABLE `cooperate_org` (
                                 `org_id` INT NOT NULL AUTO_INCREMENT COMMENT '机构ID（主键）',
                                 `org_name` VARCHAR(100) NOT NULL COMMENT '机构名称',
                                 `org_type` TINYINT NOT NULL COMMENT '机构类型：1-宠物医院，2-宠物用品商家，3-公益组织',
                                 `license_no` VARCHAR(50) NOT NULL COMMENT '资质许可证号',
                                 `contact_person` VARCHAR(50) NOT NULL COMMENT '联系人',
                                 `contact_phone` VARCHAR(20) NOT NULL COMMENT '联系电话',
                                 `address` VARCHAR(255) NOT NULL COMMENT '机构地址',
                                 `business_scope` VARCHAR(500) DEFAULT '' COMMENT '业务范围',
                                 `status` TINYINT NOT NULL DEFAULT 0 COMMENT '合作状态：0-待审核，1-正常合作，2-暂停合作，3-终止合作',
                                 `audit_time` DATETIME DEFAULT NULL COMMENT '审核通过时间',
                                 `audit_user_id` INT DEFAULT NULL COMMENT '审核管理员ID（关联sys_user.user_id）',
                                 `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                 `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                 `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                                 PRIMARY KEY (`org_id`),
                                 UNIQUE KEY `uk_license_no` (`license_no`),
                                 INDEX `idx_org_type` (`org_type`),
                                 INDEX `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='合作机构表（医疗/商家/公益组织）';




CREATE TABLE `pet_info` (
                            `pet_id` INT NOT NULL AUTO_INCREMENT COMMENT '宠物ID（主键）',
                            `pet_code` VARCHAR(32) NOT NULL COMMENT '宠物唯一编码（电子身份证）',
                            `pet_name` VARCHAR(50) NOT NULL COMMENT '宠物名称',
                            `pet_type` TINYINT NOT NULL COMMENT '宠物类型：1-猫，2-狗，3-其他',
                            `breed` VARCHAR(50) DEFAULT '' COMMENT '品种（如：中华田园猫）',
                            `age` VARCHAR(20) DEFAULT '' COMMENT '年龄（如：2岁，3个月）',
                            `gender` TINYINT DEFAULT 0 COMMENT '性别：0-未知，1-公，2-母',
                            `health_status` TINYINT NOT NULL COMMENT '健康状态：1-健康，2-轻微伤病，3-急需医疗，4-康复中',
                            `sterilization` TINYINT DEFAULT 0 COMMENT '是否绝育：0-未绝育，1-已绝育',
                            `vaccine_status` TINYINT DEFAULT 0 COMMENT '疫苗状态：0-未接种，1-部分接种，2-全程接种',
                            `chip_no` VARCHAR(50) DEFAULT '' COMMENT '芯片编号（如有）',
                            `found_place` VARCHAR(255) NOT NULL COMMENT '发现地点',
                            `found_time` DATETIME DEFAULT NULL COMMENT '发现时间',
                            `pet_desc` TEXT COMMENT '宠物描述（性格、习惯等）',
                            `pet_status` TINYINT NOT NULL COMMENT '宠物状态：1-待救助，2-救助中，3-待领养，4-已领养，5-已救助（非领养），6-不幸离世',
                            `publisher_id` INT NOT NULL COMMENT '发布者ID（关联sys_user.user_id）',
                            `publisher_type` TINYINT NOT NULL COMMENT '发布者类型：1-个人救助者，2-救助机构，3-管理员',
                            `org_id` INT DEFAULT NULL COMMENT '关联机构ID（如医疗托管，关联cooperate_org.org_id）',
                            `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                            `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                            PRIMARY KEY (`pet_id`),
                            UNIQUE KEY `uk_pet_code` (`pet_code`),
                            UNIQUE KEY `uk_chip_no` (`chip_no`),
                            INDEX `idx_pet_status` (`pet_status`),
                            INDEX `idx_publisher_id` (`publisher_id`),
                            INDEX `idx_pet_type` (`pet_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='宠物信息表（流浪/待领养宠物核心信息）';




CREATE TABLE `pet_image` (
                             `image_id` INT NOT NULL AUTO_INCREMENT COMMENT '图片ID（主键）',
                             `pet_id` INT NOT NULL COMMENT '关联宠物ID（pet_info.pet_id）',
                             `image_url` VARCHAR(255) NOT NULL COMMENT '图片URL地址',
                             `image_type` TINYINT DEFAULT 1 COMMENT '图片类型：1-外观图，2-健康证明图，3-疫苗接种图，4-其他',
                             `sort` TINYINT DEFAULT 0 COMMENT '排序（0-默认，数字越大越靠前）',
                             `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                             PRIMARY KEY (`image_id`),
                             INDEX `idx_pet_id` (`pet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='宠物图片表（宠物相关图片存储）';



CREATE TABLE `pet_archive` (
                               `archive_id` INT NOT NULL AUTO_INCREMENT COMMENT '档案ID（主键）',
                               `pet_id` INT NOT NULL COMMENT '关联宠物ID（pet_info.pet_id）',
                               `medical_record` TEXT COMMENT '医疗记录（JSON格式存储多次诊疗信息）',
                               `vaccine_record` TEXT COMMENT '疫苗记录（JSON格式存储接种时间、疫苗类型）',
                               `sterilization_time` DATETIME DEFAULT NULL COMMENT '绝育时间',
                               `adopt_record_id` INT DEFAULT NULL COMMENT '领养记录ID（关联adopt_record.adopt_id，已领养时填写）',
                               `rescue_record` TEXT COMMENT '救助记录（JSON格式存储救助过程）',
                               `last_check_time` DATETIME DEFAULT NULL COMMENT '最后体检时间',
                               `next_vaccine_time` DATETIME DEFAULT NULL COMMENT '下次疫苗时间',
                               `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                               `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                               PRIMARY KEY (`archive_id`),
                               UNIQUE KEY `uk_pet_id` (`pet_id`),
                               INDEX `idx_adopt_record_id` (`adopt_record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='宠物档案表（电子身份证对应完整档案）';



CREATE TABLE `rescue_info` (
                               `rescue_id` INT NOT NULL AUTO_INCREMENT COMMENT '救助ID（主键）',
                               `pet_id` INT NOT NULL COMMENT '关联宠物ID（pet_info.pet_id）',
                               `rescue_title` VARCHAR(100) NOT NULL COMMENT '救助标题',
                               `rescue_status` TINYINT NOT NULL COMMENT '救助状态：1-待援助，2-援助中，3-已完成，4-已取消',
                               `urgent_level` TINYINT DEFAULT 2 COMMENT '紧急程度：1-普通，2-紧急，3-非常紧急',
                               `need_type` VARCHAR(50) NOT NULL COMMENT '需求类型：医疗救助，物资援助，暂养照料，资金捐助，其他',
                               `need_desc` TEXT NOT NULL COMMENT '需求描述',
                               `target_amount` DECIMAL(10,2) DEFAULT 0 COMMENT '目标资金（元，仅资金捐助时填写）',
                               `raised_amount` DECIMAL(10,2) DEFAULT 0 COMMENT '已筹资金（元）',
                               `start_time` DATETIME NOT NULL COMMENT '救助开始时间',
                               `end_time` DATETIME DEFAULT NULL COMMENT '救助结束时间',
                               `verify_status` TINYINT DEFAULT 0 COMMENT '审核状态：0-待审核，1-审核通过，2-审核驳回',
                               `verify_user_id` INT DEFAULT NULL COMMENT '审核管理员ID（sys_user.user_id）',
                               `verify_remark` VARCHAR(500) DEFAULT '' COMMENT '审核备注',
                               `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                               `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                               PRIMARY KEY (`rescue_id`),
                               INDEX `idx_pet_id` (`pet_id`),
                               INDEX `idx_rescue_status` (`rescue_status`),
                               INDEX `idx_verify_status` (`verify_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='救助信息表（流浪宠物救助发布信息）';



CREATE TABLE `adopt_release` (
                                 `release_id` INT NOT NULL AUTO_INCREMENT COMMENT '送养ID（主键）',
                                 `pet_id` INT NOT NULL COMMENT '关联宠物ID（pet_info.pet_id）',
                                 `release_user_id` INT NOT NULL COMMENT '送养人ID（sys_user.user_id）',
                                 `adopt_condition` TEXT NOT NULL COMMENT '领养条件（居住环境、养宠经验等）',
                                 `is_agree_visit` TINYINT NOT NULL COMMENT '是否同意回访：0-不同意，1-同意',
                                 `visit_cycle` VARCHAR(50) DEFAULT '' COMMENT '回访周期（如：每月1次，每3个月1次）',
                                 `deposit_amount` DECIMAL(10,2) DEFAULT 0 COMMENT '领养押金（元）',
                                 `deposit_return_time` INT DEFAULT 6 COMMENT '押金退还月数（默认6个月）',
                                 `release_type` TINYINT NOT NULL COMMENT '送养类型：1-个人送养，2-机构送养',
                                 `verify_status` TINYINT DEFAULT 0 COMMENT '审核状态：0-待审核，1-审核通过，2-审核驳回',
                                 `verify_user_id` INT DEFAULT NULL COMMENT '审核管理员ID（sys_user.user_id）',
                                 `verify_remark` VARCHAR(500) DEFAULT '' COMMENT '审核备注',
                                 `release_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '送养发布时间',
                                 `offline_time` DATETIME DEFAULT NULL COMMENT '下架时间',
                                 `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                 `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                 `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                                 PRIMARY KEY (`release_id`),
                                 UNIQUE KEY `uk_pet_id` (`pet_id`),
                                 INDEX `idx_release_user_id` (`release_user_id`),
                                 INDEX `idx_verify_status` (`verify_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='送养信息表（宠物送养发布信息）';



CREATE TABLE `adopt_apply` (
                               `apply_id` INT NOT NULL AUTO_INCREMENT COMMENT '申请ID（主键）',
                               `release_id` INT NOT NULL COMMENT '关联送养ID（adopt_release.release_id）',
                               `pet_id` INT NOT NULL COMMENT '关联宠物ID（pet_info.pet_id）',
                               `user_id` INT NOT NULL COMMENT '申请人ID（sys_user.user_id）',
                               `apply_desc` TEXT NOT NULL COMMENT '申请描述（自身情况、养宠规划等）',
                               `living_prove_url` VARCHAR(500) DEFAULT '' COMMENT '居住证明图片URL（多个用逗号分隔）',
                               `apply_status` TINYINT NOT NULL DEFAULT 0 COMMENT '申请状态：0-待审核，1-审核通过，2-审核驳回，3-已领养，4-已取消',
                               `review_user_id` INT DEFAULT NULL COMMENT '审核人ID（送养人ID或管理员ID）',
                               `review_remark` VARCHAR(500) DEFAULT '' COMMENT '审核备注',
                               `review_time` DATETIME DEFAULT NULL COMMENT '审核时间',
                               `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间',
                               `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                               `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                               PRIMARY KEY (`apply_id`),
                               INDEX `idx_user_id` (`user_id`),
                               INDEX `idx_release_id` (`release_id`),
                               INDEX `idx_apply_status` (`apply_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='领养申请表（用户领养申请记录）';


CREATE TABLE `adopt_record` (
                                `adopt_id` INT NOT NULL AUTO_INCREMENT COMMENT '领养记录ID（主键）',
                                `apply_id` INT NOT NULL COMMENT '关联申请ID（adopt_apply.apply_id）',
                                `pet_id` INT NOT NULL COMMENT '关联宠物ID（pet_info.pet_id）',
                                `user_id` INT NOT NULL COMMENT '领养人ID（sys_user.user_id）',
                                `release_user_id` INT NOT NULL COMMENT '送养人ID（sys_user.user_id）',
                                `adopt_time` DATETIME NOT NULL COMMENT '领养时间',
                                `deposit_amount` DECIMAL(10,2) DEFAULT 0 COMMENT '实际缴纳押金（元）',
                                `deposit_status` TINYINT DEFAULT 0 COMMENT '押金状态：0-冻结，1-已退还，2-扣除',
                                `deposit_return_time` DATETIME DEFAULT NULL COMMENT '押金退还时间',
                                `agreement_url` VARCHAR(255) DEFAULT '' COMMENT '领养协议文件URL',
                                `visit_status` TINYINT DEFAULT 0 COMMENT '回访状态：0-未开始，1-回访中，2-已完成所有回访',
                                `last_visit_time` DATETIME DEFAULT NULL COMMENT '最后回访时间',
                                `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                                PRIMARY KEY (`adopt_id`),
                                UNIQUE KEY `uk_apply_id` (`apply_id`),
                                UNIQUE KEY `uk_pet_id` (`pet_id`),
                                INDEX `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='领养记录表（最终领养成功记录）';




CREATE TABLE `visit_record` (
                                `visit_id` INT NOT NULL AUTO_INCREMENT COMMENT '回访ID（主键）',
                                `adopt_id` INT NOT NULL COMMENT '关联领养ID（adopt_record.adopt_id）',
                                `pet_id` INT NOT NULL COMMENT '关联宠物ID（pet_info.pet_id）',
                                `visit_user_id` INT NOT NULL COMMENT '回访人ID（sys_user.user_id）',
                                `visit_type` TINYINT NOT NULL COMMENT '回访类型：1-线上回访，2-线下回访',
                                `visit_time` DATETIME NOT NULL COMMENT '回访时间',
                                `pet_status` TINYINT NOT NULL COMMENT '宠物状态：1-健康良好，2-一般，3-需关注，4-异常',
                                `visit_content` TEXT NOT NULL COMMENT '回访内容',
                                `visit_images` VARCHAR(500) DEFAULT '' COMMENT '回访图片URL（多个用逗号分隔）',
                                `remark` VARCHAR(500) DEFAULT '' COMMENT '备注',
                                `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                                PRIMARY KEY (`visit_id`),
                                INDEX `idx_adopt_id` (`adopt_id`),
                                INDEX `idx_visit_user_id` (`visit_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='回访记录表（领养后跟踪回访）';



CREATE TABLE `donate_record` (
                                 `donate_id` INT NOT NULL AUTO_INCREMENT COMMENT '捐赠ID（主键）',
                                 `donate_user_id` INT NOT NULL COMMENT '捐赠人ID（sys_user.user_id）',
                                 `rescue_id` INT DEFAULT NULL COMMENT '关联救助ID（rescue_info.rescue_id，仅救助捐赠）',
                                 `pet_id` INT DEFAULT NULL COMMENT '关联宠物ID（pet_info.pet_id，仅指定宠物捐赠）',
                                 `donate_type` TINYINT NOT NULL COMMENT '捐赠类型：1-资金捐赠，2-物资捐赠',
                                 `donate_amount` DECIMAL(10,2) DEFAULT 0 COMMENT '捐赠金额（元，仅资金捐赠）',
                                 `material_name` VARCHAR(100) DEFAULT '' COMMENT '物资名称（仅物资捐赠）',
                                 `material_num` INT DEFAULT 0 COMMENT '物资数量（仅物资捐赠）',
                                 `material_desc` VARCHAR(500) DEFAULT '' COMMENT '物资描述（仅物资捐赠）',
                                 `delivery_way` VARCHAR(50) DEFAULT '' COMMENT '配送方式（仅物资捐赠）',
                                 `logistics_no` VARCHAR(50) DEFAULT '' COMMENT '物流单号（仅物资捐赠）',
                                 `donate_status` TINYINT DEFAULT 1 COMMENT '捐赠状态：1-已完成，2-配送中，3-已签收，4-已取消',
                                 `donate_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '捐赠时间',
                                 `receive_user_id` INT DEFAULT NULL COMMENT '接收人ID（救助者或机构联系人）',
                                 `receive_time` DATETIME DEFAULT NULL COMMENT '接收时间',
                                 `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                 `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                 `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                                 PRIMARY KEY (`donate_id`),
                                 INDEX `idx_donate_user_id` (`donate_user_id`),
                                 INDEX `idx_rescue_id` (`rescue_id`),
                                 INDEX `idx_donate_type` (`donate_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='捐赠记录表（资金/物资捐赠记录）';



CREATE TABLE `volunteer_service` (
                                     `service_id` INT NOT NULL AUTO_INCREMENT COMMENT '服务ID（主键）',
                                     `volunteer_id` INT NOT NULL COMMENT '志愿者ID（sys_user.user_id）',
                                     `rescue_id` INT NOT NULL COMMENT '关联救助ID（rescue_info.rescue_id）',
                                     `service_type` VARCHAR(50) NOT NULL COMMENT '服务类型：抓捕救助，暂养照料，医疗辅助，活动协助，其他',
                                     `service_desc` TEXT NOT NULL COMMENT '服务描述',
                                     `service_time` DATETIME NOT NULL COMMENT '服务时间',
                                     `service_duration` INT DEFAULT 0 COMMENT '服务时长（分钟）',
                                     `service_status` TINYINT DEFAULT 0 COMMENT '服务状态：0-待执行，1-执行中，2-已完成，3-已取消',
                                     `publish_user_id` INT NOT NULL COMMENT '需求发布人ID（sys_user.user_id）',
                                     `service_remark` VARCHAR(500) DEFAULT '' COMMENT '服务备注',
                                     `service_points` INT DEFAULT 0 COMMENT '服务获得积分',
                                     `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                     `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                     `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                                     PRIMARY KEY (`service_id`),
                                     INDEX `idx_volunteer_id` (`volunteer_id`),
                                     INDEX `idx_rescue_id` (`rescue_id`),
                                     INDEX `idx_service_status` (`service_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='志愿者服务表（志愿者服务记录）';



CREATE TABLE `notice_info` (
                               `notice_id` INT NOT NULL AUTO_INCREMENT COMMENT '公告ID（主键）',
                               `notice_title` VARCHAR(100) NOT NULL COMMENT '公告标题',
                               `notice_type` TINYINT NOT NULL COMMENT '公告类型：1-政策通知，2-平台规则，3-公益活动，4-风险警示',
                               `notice_content` TEXT NOT NULL COMMENT '公告内容（支持HTML）',
                               `target_user_type` VARCHAR(50) DEFAULT '0' COMMENT '目标用户类型（多个用逗号分隔：0-所有用户，1-普通用户，2-救助者...）',
                               `is_popup` TINYINT DEFAULT 0 COMMENT '是否弹窗：0-否，1-是',
                               `publish_user_id` INT NOT NULL COMMENT '发布人ID（sys_user.user_id）',
                               `publish_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
                               `offline_time` DATETIME DEFAULT NULL COMMENT '下架时间',
                               `view_count` INT DEFAULT 0 COMMENT '查看次数',
                               `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                               `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                               PRIMARY KEY (`notice_id`),
                               INDEX `idx_notice_type` (`notice_type`),
                               INDEX `idx_publish_time` (`publish_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='公告信息表（平台公告通知）';



CREATE TABLE `complaint_report` (
                                    `complaint_id` INT NOT NULL AUTO_INCREMENT COMMENT '投诉ID（主键）',
                                    `report_user_id` INT NOT NULL COMMENT '举报人ID（sys_user.user_id，匿名则为0）',
                                    `target_type` TINYINT NOT NULL COMMENT '举报对象类型：1-用户，2-宠物信息，3-救助信息，4-机构',
                                    `target_id` INT NOT NULL COMMENT '举报对象ID（对应类型主键）',
                                    `complaint_type` TINYINT NOT NULL COMMENT '投诉类型：1-虚假信息，2-违规收费，3-虐待动物，4-骚扰他人，5-机构违规',
                                    `complaint_content` TEXT NOT NULL COMMENT '投诉内容',
                                    `evidence_url` VARCHAR(500) DEFAULT '' COMMENT '证据图片/文件URL（多个用逗号分隔）',
                                    `is_anonymous` TINYINT DEFAULT 0 COMMENT '是否匿名：0-否，1-是',
                                    `handle_status` TINYINT DEFAULT 0 COMMENT '处理状态：0-待受理，1-处理中，2-已办结，3-已驳回',
                                    `handle_user_id` INT DEFAULT NULL COMMENT '处理人ID（管理员ID）',
                                    `handle_remark` TEXT COMMENT '处理结果',
                                    `handle_time` DATETIME DEFAULT NULL COMMENT '处理时间',
                                    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '投诉时间',
                                    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                    `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                                    PRIMARY KEY (`complaint_id`),
                                    INDEX `idx_report_user_id` (`report_user_id`),
                                    INDEX `idx_target_type` (`target_type`),
                                    INDEX `idx_handle_status` (`handle_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='投诉举报表（用户投诉举报记录）';




CREATE TABLE `knowledge_course` (
                                    `course_id` INT NOT NULL AUTO_INCREMENT COMMENT '课程ID（主键）',
                                    `course_title` VARCHAR(100) NOT NULL COMMENT '课程标题',
                                    `course_type` TINYINT NOT NULL COMMENT '课程类型：1-救助实操指南，2-科学饲养宝典，3-公益常识科普，4-专家直播课堂',
                                    `difficulty_level` TINYINT DEFAULT 1 COMMENT '难度等级：1-入门，2-进阶，3-专业',
                                    `course_cover` VARCHAR(255) DEFAULT '' COMMENT '课程封面图片URL',
                                    `course_content` TEXT NOT NULL COMMENT '课程内容（支持HTML/视频链接）',
                                    `teacher_name` VARCHAR(50) DEFAULT '' COMMENT '讲师名称',
                                    `teacher_desc` VARCHAR(500) DEFAULT '' COMMENT '讲师简介',
                                    `view_count` INT DEFAULT 0 COMMENT '查看次数',
                                    `collect_count` INT DEFAULT 0 COMMENT '收藏次数',
                                    `publish_status` TINYINT DEFAULT 0 COMMENT '发布状态：0-待审核，1-已发布，2-已下架',
                                    `publish_user_id` INT NOT NULL COMMENT '发布人ID（管理员/专家ID）',
                                    `publish_time` DATETIME DEFAULT NULL COMMENT '发布时间',
                                    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                    `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                                    PRIMARY KEY (`course_id`),
                                    INDEX `idx_course_type` (`course_type`),
                                    INDEX `idx_difficulty_level` (`difficulty_level`),
                                    INDEX `idx_publish_status` (`publish_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='知识课堂表（宠物知识课程）';




CREATE TABLE `sys_config` (
                              `config_id` INT NOT NULL AUTO_INCREMENT COMMENT '配置ID（主键）',
                              `config_key` VARCHAR(50) NOT NULL COMMENT '配置键（唯一）',
                              `config_value` VARCHAR(500) NOT NULL COMMENT '配置值',
                              `config_desc` VARCHAR(255) DEFAULT '' COMMENT '配置描述',
                              `config_type` TINYINT DEFAULT 1 COMMENT '配置类型：1-基础配置，2-公益配置，3-安全配置',
                              `status` TINYINT DEFAULT 1 COMMENT '状态：0-禁用，1-启用',
                              `create_user_id` INT DEFAULT NULL COMMENT '创建人ID',
                              `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                              `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                              `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                              PRIMARY KEY (`config_id`),
                              UNIQUE KEY `uk_config_key` (`config_key`),
                              INDEX `idx_config_type` (`config_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统配置表（平台系统参数配置）';

CREATE TABLE `adopt_application` (
                              `application_id` INT NOT NULL AUTO_INCREMENT COMMENT '申请ID（主键）',
                              `release_id` INT NOT NULL COMMENT '关联送养ID（adopt_release.release_id）',
                              `pet_id` INT NOT NULL COMMENT '关联宠物ID（pet_info.pet_id）',
                              `user_id` INT NOT NULL COMMENT '申请人ID（sys_user.user_id）',
                              `housing_type` VARCHAR(20) NOT NULL COMMENT '住房类型：owned-自有，rented-租住，dormitory-宿舍',
                              `pet_allowed` TINYINT NOT NULL COMMENT '是否允许养宠：0-否，1-是',
                              `has_enclosed_balcony` TINYINT NOT NULL COMMENT '是否有封闭阳台/纱窗：0-否，1-是',
                              `family_agree` TINYINT NOT NULL COMMENT '家庭成员是否同意：0-否，1-是',
                              `has_allergy` TINYINT NOT NULL COMMENT '有无过敏情况：0-无，1-有',
                              `work_schedule` VARCHAR(100) DEFAULT '' COMMENT '工作作息',
                              `companion_time` VARCHAR(20) NOT NULL COMMENT '每天陪伴时间：less1-小于1小时，1-3-1-3小时，3-6-3-6小时，more6-大于6小时',
                              `know_basic_cost` TINYINT NOT NULL COMMENT '是否了解基础开销：0-否，1-是',
                              `can_afford_medical` TINYINT NOT NULL COMMENT '是否能承担医疗费用：0-否，1-是',
                              `scientific_feeding` TINYINT NOT NULL COMMENT '是否接受科学喂养：0-否，1-是',
                              `agree_sterilization` TINYINT NOT NULL COMMENT '是否同意绝育/牵引：0-否，1-是',
                              `pet_experience` TEXT NOT NULL COMMENT '养宠经验',
                              `future_plans` TEXT NOT NULL COMMENT '未来计划',
                              `no_abandon` TINYINT NOT NULL COMMENT '是否承诺不随意弃养：0-否，1-是',
                              `accept_visit` TINYINT NOT NULL COMMENT '是否接受回访：0-否，1-是',
                              `applicant_name` VARCHAR(50) NOT NULL COMMENT '申请人姓名',
                              `contact_phone` VARCHAR(20) NOT NULL COMMENT '联系电话',
                              `address` VARCHAR(255) NOT NULL COMMENT '居住地址',
                              `living_prove_url` VARCHAR(500) DEFAULT '' COMMENT '居住证明图片URL（多个用逗号分隔）',
                              `agreement_url` VARCHAR(500) DEFAULT '' COMMENT '签署协议URL',
                              `apply_status` TINYINT NOT NULL DEFAULT 0 COMMENT '申请状态：0-待审核，1-审核通过，2-审核驳回，3-已领养，4-已取消',
                              `review_user_id` INT DEFAULT NULL COMMENT '审核人ID（送养人ID或管理员ID）',
                              `review_remark` VARCHAR(500) DEFAULT '' COMMENT '审核备注',
                              `review_time` DATETIME DEFAULT NULL COMMENT '审核时间',
                              `deposit_amount` DECIMAL(10,2) DEFAULT 0 COMMENT '押金金额（元）',
                              `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '申请时间',
                              `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                              `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                              PRIMARY KEY (`application_id`),
                              INDEX `idx_user_id` (`user_id`),
                              INDEX `idx_release_id` (`release_id`),
                              INDEX `idx_apply_status` (`apply_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='领养申请表（扩展版，包含详细申请信息）';

CREATE TABLE `donation_application` (
                                       `donation_id` INT NOT NULL AUTO_INCREMENT COMMENT '捐赠ID（主键）',
                                       `donor_name` VARCHAR(50) NOT NULL COMMENT '捐赠人姓名',
                                       `contact_phone` VARCHAR(20) NOT NULL COMMENT '联系电话',
                                       `donation_type` VARCHAR(20) NOT NULL COMMENT '捐赠类型：food-食物，supplies-用品，medicine-药品，other-其他',
                                       `donation_method` VARCHAR(20) NOT NULL COMMENT '捐赠方式：现场捐赠，快递捐赠',
                                       `donation_address` VARCHAR(255) DEFAULT '' COMMENT '捐赠地址（现场捐赠时必填）',
                                       `shipping_address` VARCHAR(255) DEFAULT '' COMMENT '快递地址（快递捐赠时必填）',
                                       `donation_time` DATETIME NOT NULL COMMENT '捐赠时间',
                                       `remarks` TEXT COMMENT '备注',
                                       `donation_status` TINYINT DEFAULT 0 COMMENT '捐赠状态：0-待确认，1-已确认，2-已取消',
                                       `confirm_time` DATETIME DEFAULT NULL COMMENT '确认时间',
                                       `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                       `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                       `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                                       PRIMARY KEY (`donation_id`),
                                       INDEX `idx_donor_name` (`donor_name`),
                                       INDEX `idx_donation_type` (`donation_type`),
                                       INDEX `idx_donation_status` (`donation_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='物资捐赠申请表';

CREATE TABLE `donation_item` (
                                `item_id` INT NOT NULL AUTO_INCREMENT COMMENT '物品ID（主键）',
                                `donation_id` INT NOT NULL COMMENT '关联捐赠ID（donation_application.donation_id）',
                                `item_name` VARCHAR(100) NOT NULL COMMENT '物品名称',
                                `quantity` INT NOT NULL COMMENT '数量',
                                `unit` VARCHAR(20) NOT NULL COMMENT '单位',
                                `description` VARCHAR(500) DEFAULT '' COMMENT '描述',
                                `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                                PRIMARY KEY (`item_id`),
                                INDEX `idx_donation_id` (`donation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='捐赠物品明细表';

CREATE TABLE `story` (
                        `story_id` INT NOT NULL AUTO_INCREMENT COMMENT '故事ID（主键）',
                        `title` VARCHAR(200) NOT NULL COMMENT '故事标题',
                        `cover_image` TEXT DEFAULT '' COMMENT '封面图片URL',
                        `content` TEXT NOT NULL COMMENT '故事内容',
                        `author` VARCHAR(50) NOT NULL COMMENT '作者',
                        `author_id` INT DEFAULT NULL COMMENT '作者ID（sys_user.user_id）',
                        `like_count` INT DEFAULT 0 COMMENT '点赞数',
                        `comment_count` INT DEFAULT 0 COMMENT '评论数',
                        `view_count` INT DEFAULT 0 COMMENT '浏览数',
                        `status` TINYINT DEFAULT 1 COMMENT '状态：0-草稿，1-已发布，2-已删除',
                        `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                        `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                        PRIMARY KEY (`story_id`),
                        INDEX `idx_author` (`author`),
                        INDEX `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='故事会表';

CREATE TABLE `story_comment` (
                                `comment_id` INT NOT NULL AUTO_INCREMENT COMMENT '评论ID（主键）',
                                `story_id` INT NOT NULL COMMENT '关联故事ID（story.story_id）',
                                `content` TEXT NOT NULL COMMENT '评论内容',
                                `author` VARCHAR(50) NOT NULL COMMENT '评论作者',
                                `author_id` INT DEFAULT NULL COMMENT '评论作者ID（sys_user.user_id）',
                                `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
                                `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                                PRIMARY KEY (`comment_id`),
                                INDEX `idx_story_id` (`story_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='故事评论表';

CREATE TABLE `story_like` (
                             `like_id` INT NOT NULL AUTO_INCREMENT COMMENT '点赞ID（主键）',
                             `story_id` INT NOT NULL COMMENT '关联故事ID（story.story_id）',
                             `user_id` INT NOT NULL COMMENT '点赞用户ID（sys_user.user_id）',
                             `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '点赞时间',
                             `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                             PRIMARY KEY (`like_id`),
                             UNIQUE KEY `uk_story_user` (`story_id`, `user_id`),
                             INDEX `idx_story_id` (`story_id`),
                             INDEX `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='故事点赞表';

CREATE TABLE `community_post` (
                                 `post_id` INT NOT NULL AUTO_INCREMENT COMMENT '帖子ID（主键）',
                                 `title` VARCHAR(200) NOT NULL COMMENT '帖子标题',
                                 `category` VARCHAR(20) NOT NULL COMMENT '帖子分类：experience-经验分享，help-求助，fun-娱乐，other-其他',
                                 `content` TEXT NOT NULL COMMENT '帖子内容',
                                 `author` VARCHAR(50) NOT NULL COMMENT '作者',
                                 `author_id` INT DEFAULT NULL COMMENT '作者ID（sys_user.user_id）',
                                 `like_count` INT DEFAULT 0 COMMENT '点赞数',
                                 `comment_count` INT DEFAULT 0 COMMENT '评论数',
                                 `collect_count` INT DEFAULT 0 COMMENT '收藏数',
                                 `view_count` INT DEFAULT 0 COMMENT '浏览数',
                                 `status` TINYINT DEFAULT 1 COMMENT '状态：0-草稿，1-已发布，2-已删除',
                                 `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                 `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                 `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                                 PRIMARY KEY (`post_id`),
                                 INDEX `idx_author` (`author`),
                                 INDEX `idx_category` (`category`),
                                 INDEX `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='社区帖子表';

CREATE TABLE `community_comment` (
                                    `comment_id` INT NOT NULL AUTO_INCREMENT COMMENT '评论ID（主键）',
                                    `post_id` INT NOT NULL COMMENT '关联帖子ID（community_post.post_id）',
                                    `content` TEXT NOT NULL COMMENT '评论内容',
                                    `author` VARCHAR(50) NOT NULL COMMENT '评论作者',
                                    `author_id` INT DEFAULT NULL COMMENT '评论作者ID（sys_user.user_id）',
                                    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
                                    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                    `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                                    PRIMARY KEY (`comment_id`),
                                    INDEX `idx_post_id` (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='社区评论表';

CREATE TABLE `community_like` (
                                 `like_id` INT NOT NULL AUTO_INCREMENT COMMENT '点赞ID（主键）',
                                 `post_id` INT NOT NULL COMMENT '关联帖子ID（community_post.post_id）',
                                 `user_id` INT NOT NULL COMMENT '点赞用户ID（sys_user.user_id）',
                                 `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '点赞时间',
                                 `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                                 PRIMARY KEY (`like_id`),
                                 UNIQUE KEY `uk_post_user` (`post_id`, `user_id`),
                                 INDEX `idx_post_id` (`post_id`),
                                 INDEX `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='社区点赞表';

CREATE TABLE `collection` (
                             `collection_id` INT NOT NULL AUTO_INCREMENT COMMENT '收藏ID（主键）',
                             `post_id` INT NOT NULL COMMENT '关联帖子ID（community_post.post_id）',
                             `user_id` INT NOT NULL COMMENT '收藏用户ID（sys_user.user_id）',
                             `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '收藏时间',
                             `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                             PRIMARY KEY (`collection_id`),
                             UNIQUE KEY `uk_post_user` (`post_id`, `user_id`),
                             INDEX `idx_post_id` (`post_id`),
                             INDEX `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='收藏表';

CREATE TABLE `volunteer` (
                            `volunteer_id` INT NOT NULL AUTO_INCREMENT COMMENT '志愿者ID（主键）',
                            `name` VARCHAR(50) NOT NULL COMMENT '姓名',
                            `phone` VARCHAR(20) NOT NULL COMMENT '联系电话',
                            `email` VARCHAR(100) DEFAULT '' COMMENT '邮箱',
                            `skills` VARCHAR(500) DEFAULT '' COMMENT '技能特长',
                            `status` TINYINT NOT NULL DEFAULT 0 COMMENT '状态：0-待审核，1-已通过，2-已驳回，3-已注销',
                            `audit_time` DATETIME DEFAULT NULL COMMENT '审核时间',
                            `audit_user_id` INT DEFAULT NULL COMMENT '审核管理员ID（sys_user.user_id）',
                            `audit_comments` VARCHAR(500) DEFAULT '' COMMENT '审核意见',
                            `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                            `is_deleted` TINYINT DEFAULT 0 COMMENT '逻辑删除：0-正常，1-删除',
                            PRIMARY KEY (`volunteer_id`),
                            INDEX `idx_name` (`name`),
                            INDEX `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='志愿者表';
