CREATE TABLE `adopt_application` (
                              `application_id` INT NOT NULL AUTO_INCREMENT COMMENT '鐢宠ID锛堜富閿級',
                              `release_id` INT NOT NULL COMMENT '鍏宠仈閫佸吇ID锛坅dopt_release.release_id锛?,
                              `pet_id` INT NOT NULL COMMENT '鍏宠仈瀹犵墿ID锛坧et_info.pet_id锛?,
                              `user_id` INT NOT NULL COMMENT '鐢宠浜篒D锛坰ys_user.user_id锛?,
                              `housing_type` VARCHAR(20) NOT NULL COMMENT '浣忔埧绫诲瀷锛歰wned-鑷湁锛宺ented-绉熶綇锛宒ormitory-瀹胯垗',
                              `pet_allowed` TINYINT NOT NULL COMMENT '鏄惁鍏佽鍏诲疇锛?-鍚︼紝1-鏄?,
                              `has_enclosed_balcony` TINYINT NOT NULL COMMENT '鏄惁鏈夊皝闂槼鍙?绾辩獥锛?-鍚︼紝1-鏄?,
                              `family_agree` TINYINT NOT NULL COMMENT '瀹跺涵鎴愬憳鏄惁鍚屾剰锛?-鍚︼紝1-鏄?,
                              `has_allergy` TINYINT NOT NULL COMMENT '鏈夋棤杩囨晱鎯呭喌锛?-鏃狅紝1-鏈?,
                              `work_schedule` VARCHAR(100) DEFAULT '' COMMENT '宸ヤ綔浣滄伅',
                              `companion_time` VARCHAR(20) NOT NULL COMMENT '姣忓ぉ闄即鏃堕棿锛歭ess1-灏忎簬1灏忔椂锛?-3-1-3灏忔椂锛?-6-3-6灏忔椂锛宮ore6-澶т簬6灏忔椂',
                              `know_basic_cost` TINYINT NOT NULL COMMENT '鏄惁浜嗚В鍩虹寮€閿€锛?-鍚︼紝1-鏄?,
                              `can_afford_medical` TINYINT NOT NULL COMMENT '鏄惁鑳芥壙鎷呭尰鐤楄垂鐢細0-鍚︼紝1-鏄?,
                              `scientific_feeding` TINYINT NOT NULL COMMENT '鏄惁鎺ュ彈绉戝鍠傚吇锛?-鍚︼紝1-鏄?,
                              `agree_sterilization` TINYINT NOT NULL COMMENT '鏄惁鍚屾剰缁濊偛/鐗靛紩锛?-鍚︼紝1-鏄?,
                              `pet_experience` TEXT NOT NULL COMMENT '鍏诲疇缁忛獙',
                              `future_plans` TEXT NOT NULL COMMENT '鏈潵璁″垝',
                              `no_abandon` TINYINT NOT NULL COMMENT '鏄惁鎵胯涓嶉殢鎰忓純鍏伙細0-鍚︼紝1-鏄?,
                              `accept_visit` TINYINT NOT NULL COMMENT '鏄惁鎺ュ彈鍥炶锛?-鍚︼紝1-鏄?,
                              `applicant_name` VARCHAR(50) NOT NULL COMMENT '鐢宠浜哄鍚?,
                              `contact_phone` VARCHAR(20) NOT NULL COMMENT '鑱旂郴鐢佃瘽',
                              `address` VARCHAR(255) NOT NULL COMMENT '灞呬綇鍦板潃',
                              `living_prove_url` VARCHAR(500) DEFAULT '' COMMENT '灞呬綇璇佹槑鍥剧墖URL锛堝涓敤閫楀彿鍒嗛殧锛?,
                              `agreement_url` VARCHAR(500) DEFAULT '' COMMENT '绛剧讲鍗忚URL',
                              `apply_status` TINYINT NOT NULL DEFAULT 0 COMMENT '鐢宠鐘舵€侊細0-寰呭鏍革紝1-瀹℃牳閫氳繃锛?-瀹℃牳椹冲洖锛?-宸查鍏伙紝4-宸插彇娑?,
                              `review_user_id` INT DEFAULT NULL COMMENT '瀹℃牳浜篒D锛堥€佸吇浜篒D鎴栫鐞嗗憳ID锛?,
                              `review_remark` VARCHAR(500) DEFAULT '' COMMENT '瀹℃牳澶囨敞',
                              `review_time` DATETIME DEFAULT NULL COMMENT '瀹℃牳鏃堕棿',
                              `deposit_amount` DECIMAL(10,2) DEFAULT 0 COMMENT '鎶奸噾閲戦锛堝厓锛?,
                              `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鐢宠鏃堕棿',
                              `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '鏇存柊鏃堕棿',
                              `is_deleted` TINYINT DEFAULT 0 COMMENT '閫昏緫鍒犻櫎锛?-姝ｅ父锛?-鍒犻櫎',
                              PRIMARY KEY (`application_id`),
                              INDEX `idx_user_id` (`user_id`),
                              INDEX `idx_release_id` (`release_id`),
                              INDEX `idx_apply_status` (`apply_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='棰嗗吇鐢宠琛紙鎵╁睍鐗堬紝鍖呭惈璇︾粏鐢宠淇℃伅锛?;

CREATE TABLE `donation_application` (
                                       `donation_id` INT NOT NULL AUTO_INCREMENT COMMENT '鎹愯禒ID锛堜富閿級',
                                       `donor_name` VARCHAR(50) NOT NULL COMMENT '鎹愯禒浜哄鍚?,
                                       `contact_phone` VARCHAR(20) NOT NULL COMMENT '鑱旂郴鐢佃瘽',
                                       `donation_type` VARCHAR(20) NOT NULL COMMENT '鎹愯禒绫诲瀷锛歠ood-椋熺墿锛宻upplies-鐢ㄥ搧锛宮edicine-鑽搧锛宱ther-鍏朵粬',
                                       `donation_method` VARCHAR(20) NOT NULL COMMENT '鎹愯禒鏂瑰紡锛氱幇鍦烘崘璧狅紝蹇€掓崘璧?,
                                       `donation_address` VARCHAR(255) DEFAULT '' COMMENT '鎹愯禒鍦板潃锛堢幇鍦烘崘璧犳椂蹇呭～锛?,
                                       `shipping_address` VARCHAR(255) DEFAULT '' COMMENT '蹇€掑湴鍧€锛堝揩閫掓崘璧犳椂蹇呭～锛?,
                                       `donation_time` DATETIME NOT NULL COMMENT '鎹愯禒鏃堕棿',
                                       `remarks` TEXT COMMENT '澶囨敞',
                                       `donation_status` TINYINT DEFAULT 0 COMMENT '鎹愯禒鐘舵€侊細0-寰呯‘璁わ紝1-宸茬‘璁わ紝2-宸插彇娑?,
                                       `confirm_time` DATETIME DEFAULT NULL COMMENT '纭鏃堕棿',
                                       `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
                                       `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '鏇存柊鏃堕棿',
                                       `is_deleted` TINYINT DEFAULT 0 COMMENT '閫昏緫鍒犻櫎锛?-姝ｅ父锛?-鍒犻櫎',
                                       PRIMARY KEY (`donation_id`),
                                       INDEX `idx_donor_name` (`donor_name`),
                                       INDEX `idx_donation_type` (`donation_type`),
                                       INDEX `idx_donation_status` (`donation_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='鐗╄祫鎹愯禒鐢宠琛?;

CREATE TABLE `donation_item` (
                                `item_id` INT NOT NULL AUTO_INCREMENT COMMENT '鐗╁搧ID锛堜富閿級',
                                `donation_id` INT NOT NULL COMMENT '鍏宠仈鎹愯禒ID锛坉onation_application.donation_id锛?,
                                `item_name` VARCHAR(100) NOT NULL COMMENT '鐗╁搧鍚嶇О',
                                `quantity` INT NOT NULL COMMENT '鏁伴噺',
                                `unit` VARCHAR(20) NOT NULL COMMENT '鍗曚綅',
                                `description` VARCHAR(500) DEFAULT '' COMMENT '鎻忚堪',
                                `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
                                `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '鏇存柊鏃堕棿',
                                `is_deleted` TINYINT DEFAULT 0 COMMENT '閫昏緫鍒犻櫎锛?-姝ｅ父锛?-鍒犻櫎',
                                PRIMARY KEY (`item_id`),
                                INDEX `idx_donation_id` (`donation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='鎹愯禒鐗╁搧鏄庣粏琛?;

CREATE TABLE `story` (
                        `story_id` INT NOT NULL AUTO_INCREMENT COMMENT '鏁呬簨ID锛堜富閿級',
                        `title` VARCHAR(200) NOT NULL COMMENT '鏁呬簨鏍囬',
                        `cover_image` TEXT DEFAULT '' COMMENT '灏侀潰鍥剧墖URL',
                        `content` TEXT NOT NULL COMMENT '鏁呬簨鍐呭',
                        `author` VARCHAR(50) NOT NULL COMMENT '浣滆€?,
                        `author_id` INT DEFAULT NULL COMMENT '浣滆€匢D锛坰ys_user.user_id锛?,
                        `like_count` INT DEFAULT 0 COMMENT '鐐硅禐鏁?,
                        `comment_count` INT DEFAULT 0 COMMENT '璇勮鏁?,
                        `view_count` INT DEFAULT 0 COMMENT '娴忚鏁?,
                        `status` TINYINT DEFAULT 1 COMMENT '鐘舵€侊細0-鑽夌锛?-宸插彂甯冿紝2-宸插垹闄?,
                        `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
                        `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '鏇存柊鏃堕棿',
                        `is_deleted` TINYINT DEFAULT 0 COMMENT '閫昏緫鍒犻櫎锛?-姝ｅ父锛?-鍒犻櫎',
                        PRIMARY KEY (`story_id`),
                        INDEX `idx_author` (`author`),
                        INDEX `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='鏁呬簨浼氳〃';

CREATE TABLE `story_comment` (
                                `comment_id` INT NOT NULL AUTO_INCREMENT COMMENT '璇勮ID锛堜富閿級',
                                `story_id` INT NOT NULL COMMENT '鍏宠仈鏁呬簨ID锛坰tory.story_id锛?,
                                `content` TEXT NOT NULL COMMENT '璇勮鍐呭',
                                `author` VARCHAR(50) NOT NULL COMMENT '璇勮浣滆€?,
                                `author_id` INT DEFAULT NULL COMMENT '璇勮浣滆€匢D锛坰ys_user.user_id锛?,
                                `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '璇勮鏃堕棿',
                                `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '鏇存柊鏃堕棿',
                                `is_deleted` TINYINT DEFAULT 0 COMMENT '閫昏緫鍒犻櫎锛?-姝ｅ父锛?-鍒犻櫎',
                                PRIMARY KEY (`comment_id`),
                                INDEX `idx_story_id` (`story_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='鏁呬簨璇勮琛?;

CREATE TABLE `story_like` (
                             `like_id` INT NOT NULL AUTO_INCREMENT COMMENT '鐐硅禐ID锛堜富閿級',
                             `story_id` INT NOT NULL COMMENT '鍏宠仈鏁呬簨ID锛坰tory.story_id锛?,
                             `user_id` INT NOT NULL COMMENT '鐐硅禐鐢ㄦ埛ID锛坰ys_user.user_id锛?,
                             `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鐐硅禐鏃堕棿',
                             `is_deleted` TINYINT DEFAULT 0 COMMENT '閫昏緫鍒犻櫎锛?-姝ｅ父锛?-鍒犻櫎',
                             PRIMARY KEY (`like_id`),
                             UNIQUE KEY `uk_story_user` (`story_id`, `user_id`),
                             INDEX `idx_story_id` (`story_id`),
                             INDEX `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='鏁呬簨鐐硅禐琛?;

CREATE TABLE `community_post` (
                                 `post_id` INT NOT NULL AUTO_INCREMENT COMMENT '甯栧瓙ID锛堜富閿級',
                                 `title` VARCHAR(200) NOT NULL COMMENT '甯栧瓙鏍囬',
                                 `category` VARCHAR(20) NOT NULL COMMENT '甯栧瓙鍒嗙被锛歟xperience-缁忛獙鍒嗕韩锛宧elp-姹傚姪锛宖un-濞变箰锛宱ther-鍏朵粬',
                                 `content` TEXT NOT NULL COMMENT '甯栧瓙鍐呭',
                                 `author` VARCHAR(50) NOT NULL COMMENT '浣滆€?,
                                 `author_id` INT DEFAULT NULL COMMENT '浣滆€匢D锛坰ys_user.user_id锛?,
                                 `like_count` INT DEFAULT 0 COMMENT '鐐硅禐鏁?,
                                 `comment_count` INT DEFAULT 0 COMMENT '璇勮鏁?,
                                 `collect_count` INT DEFAULT 0 COMMENT '鏀惰棌鏁?,
                                 `view_count` INT DEFAULT 0 COMMENT '娴忚鏁?,
                                 `status` TINYINT DEFAULT 1 COMMENT '鐘舵€侊細0-鑽夌锛?-宸插彂甯冿紝2-宸插垹闄?,
                                 `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
                                 `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '鏇存柊鏃堕棿',
                                 `is_deleted` TINYINT DEFAULT 0 COMMENT '閫昏緫鍒犻櫎锛?-姝ｅ父锛?-鍒犻櫎',
                                 PRIMARY KEY (`post_id`),
                                 INDEX `idx_author` (`author`),
                                 INDEX `idx_category` (`category`),
                                 INDEX `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='绀惧尯甯栧瓙琛?;

CREATE TABLE `community_comment` (
                                    `comment_id` INT NOT NULL AUTO_INCREMENT COMMENT '璇勮ID锛堜富閿級',
                                    `post_id` INT NOT NULL COMMENT '鍏宠仈甯栧瓙ID锛坈ommunity_post.post_id锛?,
                                    `content` TEXT NOT NULL COMMENT '璇勮鍐呭',
                                    `author` VARCHAR(50) NOT NULL COMMENT '璇勮浣滆€?,
                                    `author_id` INT DEFAULT NULL COMMENT '璇勮浣滆€匢D锛坰ys_user.user_id锛?,
                                    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '璇勮鏃堕棿',
                                    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '鏇存柊鏃堕棿',
                                    `is_deleted` TINYINT DEFAULT 0 COMMENT '閫昏緫鍒犻櫎锛?-姝ｅ父锛?-鍒犻櫎',
                                    PRIMARY KEY (`comment_id`),
                                    INDEX `idx_post_id` (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='绀惧尯璇勮琛?;

CREATE TABLE `community_like` (
                                 `like_id` INT NOT NULL AUTO_INCREMENT COMMENT '鐐硅禐ID锛堜富閿級',
                                 `post_id` INT NOT NULL COMMENT '鍏宠仈甯栧瓙ID锛坈ommunity_post.post_id锛?,
                                 `user_id` INT NOT NULL COMMENT '鐐硅禐鐢ㄦ埛ID锛坰ys_user.user_id锛?,
                                 `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鐐硅禐鏃堕棿',
                                 `is_deleted` TINYINT DEFAULT 0 COMMENT '閫昏緫鍒犻櫎锛?-姝ｅ父锛?-鍒犻櫎',
                                 PRIMARY KEY (`like_id`),
                                 UNIQUE KEY `uk_post_user` (`post_id`, `user_id`),
                                 INDEX `idx_post_id` (`post_id`),
                                 INDEX `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='绀惧尯鐐硅禐琛?;

CREATE TABLE `collection` (
                             `collection_id` INT NOT NULL AUTO_INCREMENT COMMENT '鏀惰棌ID锛堜富閿級',
                             `post_id` INT NOT NULL COMMENT '鍏宠仈甯栧瓙ID锛坈ommunity_post.post_id锛?,
                             `user_id` INT NOT NULL COMMENT '鏀惰棌鐢ㄦ埛ID锛坰ys_user.user_id锛?,
                             `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鏀惰棌鏃堕棿',
                             `is_deleted` TINYINT DEFAULT 0 COMMENT '閫昏緫鍒犻櫎锛?-姝ｅ父锛?-鍒犻櫎',
                             PRIMARY KEY (`collection_id`),
                             UNIQUE KEY `uk_post_user` (`post_id`, `user_id`),
                             INDEX `idx_post_id` (`post_id`),
                             INDEX `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='鏀惰棌琛?;

CREATE TABLE `volunteer` (
                            `volunteer_id` INT NOT NULL AUTO_INCREMENT COMMENT '蹇楁効鑰匢D锛堜富閿級',
                            `name` VARCHAR(50) NOT NULL COMMENT '濮撳悕',
                            `phone` VARCHAR(20) NOT NULL COMMENT '鑱旂郴鐢佃瘽',
                            `email` VARCHAR(100) DEFAULT '' COMMENT '閭',
                            `skills` VARCHAR(500) DEFAULT '' COMMENT '鎶€鑳界壒闀?,
                            `status` TINYINT NOT NULL DEFAULT 0 COMMENT '鐘舵€侊細0-寰呭鏍革紝1-宸查€氳繃锛?-宸查┏鍥烇紝3-宸叉敞閿€',
                            `audit_time` DATETIME DEFAULT NULL COMMENT '瀹℃牳鏃堕棿',
                            `audit_user_id` INT DEFAULT NULL COMMENT '瀹℃牳绠＄悊鍛業D锛坰ys_user.user_id锛?,
                            `audit_comments` VARCHAR(500) DEFAULT '' COMMENT '瀹℃牳鎰忚',
                            `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '鍒涘缓鏃堕棿',
                            `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '鏇存柊鏃堕棿',
                            `is_deleted` TINYINT DEFAULT 0 COMMENT '閫昏緫鍒犻櫎锛?-姝ｅ父锛?-鍒犻櫎',
                            PRIMARY KEY (`volunteer_id`),
                            INDEX `idx_name` (`name`),
                            INDEX `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='蹇楁効鑰呰〃';
