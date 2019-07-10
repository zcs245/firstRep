/*
Navicat MySQL Data Transfer

Source Server         : Database1
Source Server Version : 50524
Source Host           : localhost:3306
Source Database       : myproject

Target Server Type    : MYSQL
Target Server Version : 50524
File Encoding         : 65001

Date: 2019-06-16 19:54:23
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `sys_classes`
-- ----------------------------
DROP TABLE IF EXISTS `sys_classes`;
CREATE TABLE `sys_classes` (
  `class_number` varchar(100) NOT NULL,
  `class_type` varchar(100) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '9',
  PRIMARY KEY (`class_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班级';

-- ----------------------------
-- Records of sys_classes
-- ----------------------------
INSERT INTO `sys_classes` VALUES ('软件1班', '本科', '9');
INSERT INTO `sys_classes` VALUES ('软件2班', '本科', '9');

-- ----------------------------
-- Table structure for `sys_course`
-- ----------------------------
DROP TABLE IF EXISTS `sys_course`;
CREATE TABLE `sys_course` (
  `course_code` int(11) NOT NULL,
  `course_name` varchar(100) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '9',
  PRIMARY KEY (`course_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程';

-- ----------------------------
-- Records of sys_course
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_lesson_plan`
-- ----------------------------
DROP TABLE IF EXISTS `sys_lesson_plan`;
CREATE TABLE `sys_lesson_plan` (
  `course_tid` int(11) NOT NULL,
  `course_tname` varchar(100) NOT NULL,
  `time` varchar(100) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '9',
  KEY `FK_Reference_3` (`course_tid`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`course_tid`) REFERENCES `sys_teachers` (`id_tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='授课计划';

-- ----------------------------
-- Records of sys_lesson_plan
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_restrictive_condition_1`
-- ----------------------------
DROP TABLE IF EXISTS `sys_restrictive_condition_1`;
CREATE TABLE `sys_restrictive_condition_1` (
  `restrictive_code` int(11) NOT NULL,
  `course_type` varchar(100) DEFAULT NULL,
  `r_title` varchar(100) DEFAULT NULL,
  `status` tinyint(4) DEFAULT '9',
  KEY `FK_Reference_9` (`restrictive_code`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`restrictive_code`) REFERENCES `sys_course` (`course_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='限制条件';

-- ----------------------------
-- Records of sys_restrictive_condition_1
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_restrictive_condition_2`
-- ----------------------------
DROP TABLE IF EXISTS `sys_restrictive_condition_2`;
CREATE TABLE `sys_restrictive_condition_2` (
  `restrictive_tid` int(11) NOT NULL,
  `min_week_hour` int(11) DEFAULT NULL,
  `max_week_hour` int(11) DEFAULT NULL,
  `max_course_number` int(11) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  KEY `FK_Reference_10` (`restrictive_tid`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`restrictive_tid`) REFERENCES `sys_teachers` (`id_tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_restrictive_condition_2
-- ----------------------------
INSERT INTO `sys_restrictive_condition_2` VALUES ('3001', null, null, null, null);
INSERT INTO `sys_restrictive_condition_2` VALUES ('3002', null, null, null, null);
INSERT INTO `sys_restrictive_condition_2` VALUES ('3003', null, null, null, null);
INSERT INTO `sys_restrictive_condition_2` VALUES ('3004', null, null, null, null);

-- ----------------------------
-- Table structure for `sys_students`
-- ----------------------------
DROP TABLE IF EXISTS `sys_students`;
CREATE TABLE `sys_students` (
  `id_sid` int(11) NOT NULL,
  `student_cnum` varchar(100) NOT NULL,
  `s_name` varchar(100) NOT NULL,
  `stauts` tinyint(4) NOT NULL DEFAULT '9',
  KEY `FK_Reference_7` (`id_sid`),
  KEY `FK_Reference_8` (`student_cnum`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`id_sid`) REFERENCES `sys_users` (`id`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`student_cnum`) REFERENCES `sys_classes` (`class_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学生';

-- ----------------------------
-- Records of sys_students
-- ----------------------------
INSERT INTO `sys_students` VALUES ('4001', '软件1班', '吴七', '9');
INSERT INTO `sys_students` VALUES ('4002', '软件2班', '郑八', '9');

-- ----------------------------
-- Table structure for `sys_teacher_plan`
-- ----------------------------
DROP TABLE IF EXISTS `sys_teacher_plan`;
CREATE TABLE `sys_teacher_plan` (
  `tp_cnum` varchar(100) NOT NULL,
  `tp_code` int(11) NOT NULL,
  `course_hour` int(11) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '9',
  KEY `FK_Reference_5` (`tp_cnum`),
  KEY `FK_Reference_6` (`tp_code`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`tp_code`) REFERENCES `sys_course` (`course_code`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`tp_cnum`) REFERENCES `sys_classes` (`class_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教学计划';

-- ----------------------------
-- Records of sys_teacher_plan
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_teachers`
-- ----------------------------
DROP TABLE IF EXISTS `sys_teachers`;
CREATE TABLE `sys_teachers` (
  `id_tid` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `teach_situation` varchar(100) NOT NULL,
  `title` varchar(100) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '9',
  PRIMARY KEY (`id_tid`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`id_tid`) REFERENCES `sys_users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='老师';

-- ----------------------------
-- Records of sys_teachers
-- ----------------------------
INSERT INTO `sys_teachers` VALUES ('3001', '赵一', '良好', '助教', '9');
INSERT INTO `sys_teachers` VALUES ('3002', '钱二', '良好', '讲师', '9');
INSERT INTO `sys_teachers` VALUES ('3003', '孙三', '严重事故', '讲师', '9');
INSERT INTO `sys_teachers` VALUES ('3004', '李四', '良好', '讲师', '9');

-- ----------------------------
-- Table structure for `sys_tesk_schedule`
-- ----------------------------
DROP TABLE IF EXISTS `sys_tesk_schedule`;
CREATE TABLE `sys_tesk_schedule` (
  `time` varchar(100) NOT NULL,
  `course` varchar(100) NOT NULL,
  `teacher` varchar(100) NOT NULL,
  `classes` varchar(100) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '9'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务书_课表';

-- ----------------------------
-- Records of sys_tesk_schedule
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_users`
-- ----------------------------
DROP TABLE IF EXISTS `sys_users`;
CREATE TABLE `sys_users` (
  `user` varchar(100) NOT NULL,
  `id` int(11) NOT NULL,
  `password` int(11) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '9',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of sys_users
-- ----------------------------
INSERT INTO `sys_users` VALUES ('校教务', '111', '123', '9');
INSERT INTO `sys_users` VALUES ('院教务', '222', '456', '9');
INSERT INTO `sys_users` VALUES ('老师', '3001', '331', '9');
INSERT INTO `sys_users` VALUES ('老师', '3002', '332', '9');
INSERT INTO `sys_users` VALUES ('老师', '3003', '333', '9');
INSERT INTO `sys_users` VALUES ('老师', '3004', '334', '9');
INSERT INTO `sys_users` VALUES ('学生', '4001', '441', '9');
INSERT INTO `sys_users` VALUES ('学生', '4002', '442', '9');
