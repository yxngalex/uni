/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     10/3/2023 6:05:10 PM                         */
/*==============================================================*/


drop table if exists CATEGORY;

drop table if exists DAY;

drop table if exists EXERCISE;

drop table if exists EXERCISE_STATS;

drop table if exists FOOD;

drop table if exists FOOD_MEAL;

drop table if exists GOAL;

drop table if exists MEAL;

drop table if exists MEAL_NUTRITION;

drop table if exists NUTRITION;

drop table if exists TROPHY;

drop table if exists TROPHY_USER;

drop table if exists USER;

drop table if exists WORKOUT_ROUTINE;

drop table if exists WORKOUT_ROUTINE_EXERCISE;

/*==============================================================*/
/* Table: CATEGORY                                              */
/*==============================================================*/
create table CATEGORY
(
   CATEGORY_ID          int not null AUTO_INCREMENT,
   CATEGORY_NAME        varchar(255),
   CATEGORY_DESCRIPTION varchar(255),
   primary key (CATEGORY_ID)
);

/*==============================================================*/
/* Table: DAY                                                   */
/*==============================================================*/
create table DAY
(
   DAY_ID               int not null AUTO_INCREMENT,
   NUTRITION_FK         int not null,
   USER_FK              int not null,
   WORKOUT_ROUTINE_FK   int,
   LOGGED_DATE          date,
   IS_DELETED           bool,
   primary key (DAY_ID)
);

/*==============================================================*/
/* Table: EXERCISE                                              */
/*==============================================================*/
create table EXERCISE
(
   EXERCISE_ID          int not null AUTO_INCREMENT,
   EXERCISE_STATS_FK    int,
   CATEGORY_FK          int not null,
   EXERCISE_NAME        varchar(255),
   EXERCISE_DESCRIPTION varchar(255),
   FAVORITED            bool,
   IS_DELETED           bool,
   primary key (EXERCISE_ID)
);

/*==============================================================*/
/* Table: EXERCISE_STATS                                        */
/*==============================================================*/
create table EXERCISE_STATS
(
   EXERCISE_STATS_ID    int not null AUTO_INCREMENT,
   `SET`                int,
   REPS                 int,
   EXERCISE_WEIGHT      decimal,
   primary key (EXERCISE_STATS_ID)
);

/*==============================================================*/
/* Table: FOOD                                                  */
/*==============================================================*/
create table FOOD
(
   FOOD_ID              int not null AUTO_INCREMENT,
   NUTRITION_FK         int not null,
   FOOD_NAME            varchar(255),
   FOOD_GROUP           varchar(255),
   SERVING              int,
   IS_DELETED           bool,
   primary key (FOOD_ID)
);

/*==============================================================*/
/* Table: FOOD_MEAL                                             */
/*==============================================================*/
create table FOOD_MEAL
(
   FOOD_MEAL_ID         int not null AUTO_INCREMENT,
   MEAL_FK              int not null,
   FOOD_FK              int not null,
   primary key (FOOD_MEAL_ID)
);

/*==============================================================*/
/* Table: GOAL                                                  */
/*==============================================================*/
create table GOAL
(
   GOAL_ID              int not null AUTO_INCREMENT,
   USER_FK              int not null,
   WEIGHT_GOAL          decimal,
   BODY_TYPE_GOAL       varchar(255),
   WEEKLY_EXERCISE      int,
   primary key (GOAL_ID)
);

/*==============================================================*/
/* Table: MEAL                                                  */
/*==============================================================*/
create table MEAL
(
   MEAL_ID              int not null AUTO_INCREMENT,
   DAY_FK               int not null,
   MEAL_NAME            varchar(255),
   IS_DELETED           bool,
   primary key (MEAL_ID)
);

/*==============================================================*/
/* Table: MEAL_NUTRITION                                        */
/*==============================================================*/
create table MEAL_NUTRITION
(
   MEAL_NUTRITION_ID    int not null AUTO_INCREMENT,
   MEAL_FK              int not null,
   NUTRITION_FK         int not null,
   primary key (MEAL_NUTRITION_ID)
);

/*==============================================================*/
/* Table: NUTRITION                                             */
/*==============================================================*/
create table NUTRITION
(
   NUTRITION_ID         int not null AUTO_INCREMENT,
   CALORIES             decimal,
   PROTEIN              decimal,
   CARBS                decimal,
   FAT                  decimal,
   primary key (NUTRITION_ID)
);

/*==============================================================*/
/* Table: TROPHY                                                */
/*==============================================================*/
create table TROPHY
(
   TROPHY_ID            int not null AUTO_INCREMENT,
   TROPGY_NAME          varchar(255),
   TROPHY_DESCRIPTION   varchar(255),
   TROPHY_IMAGE         varchar(255),
   primary key (TROPHY_ID)
);

/*==============================================================*/
/* Table: TROPHY_USER                                           */
/*==============================================================*/
create table TROPHY_USER
(
   TROPHY_USER_ID       int not null AUTO_INCREMENT,
   TROPHY_FK            int,
   USER_FK              int,
   IS_ACHIEVED          bool,
   DATE_ACHIEVED        date,
   primary key (TROPHY_USER_ID)
);

/*==============================================================*/
/* Table: USER                                                  */
/*==============================================================*/
create table USER
(
   USER_ID              int not null AUTO_INCREMENT,
   LAST_NAME            varchar(255),
   USERNAME             varchar(255),
   PASSWORD             varchar(255),
   IS_DELETED           bool,
   FIRST_NAME           varchar(255),
   EMAIL                varchar(255),
   HEIGHT               decimal,
   WEIGHT               decimal,
   AGE                  int,
   GENDER               varchar(255),
   CURRENT_BODY_TYPE    varchar(255),
   primary key (USER_ID)
);

/*==============================================================*/
/* Table: WORKOUT_ROUTINE                                       */
/*==============================================================*/
create table WORKOUT_ROUTINE
(
   WORKOUT_ROUTINE_ID   int not null AUTO_INCREMENT,
   CATEGORY_FK          int,
   GOAL_FK              int,
   DATE_START           date,
   DATE_FINISH          date,
   primary key (WORKOUT_ROUTINE_ID)
);

/*==============================================================*/
/* Table: WORKOUT_ROUTINE_EXERCISE                              */
/*==============================================================*/
create table WORKOUT_ROUTINE_EXERCISE
(
   WORKOUT_ROUTINE_EXERCISE_ID int not null AUTO_INCREMENT,
   WORKOUT_ROUTINE_FK   int,
   EXERCISE_FK          int,
   primary key (WORKOUT_ROUTINE_EXERCISE_ID)
);

alter table DAY add constraint FK_CONSIST foreign key (NUTRITION_FK)
      references NUTRITION (NUTRITION_ID) on delete restrict on update restrict;

alter table DAY add constraint FK_CONSIST_OF foreign key (WORKOUT_ROUTINE_FK)
      references WORKOUT_ROUTINE (WORKOUT_ROUTINE_ID) on delete restrict on update restrict;

alter table DAY add constraint FK_DAY_USER foreign key (USER_FK)
      references USER (USER_ID) on delete restrict on update restrict;

alter table EXERCISE add constraint FK_DETAILS foreign key (EXERCISE_STATS_FK)
      references EXERCISE_STATS (EXERCISE_STATS_ID) on delete restrict on update restrict;

alter table EXERCISE add constraint FK_IS foreign key (CATEGORY_FK)
      references CATEGORY (CATEGORY_ID) on delete restrict on update restrict;

alter table FOOD add constraint FK_HAS foreign key (NUTRITION_FK)
      references NUTRITION (NUTRITION_ID) on delete restrict on update restrict;

alter table FOOD_MEAL add constraint FK_CONTAINS foreign key (MEAL_FK)
      references MEAL (MEAL_ID) on delete restrict on update restrict;

alter table FOOD_MEAL add constraint FK_IS_PART_OF foreign key (FOOD_FK)
      references FOOD (FOOD_ID) on delete restrict on update restrict;

alter table GOAL add constraint FK_MOTIVATES foreign key (USER_FK)
      references USER (USER_ID) on delete restrict on update restrict;

alter table MEAL add constraint FK_CONSUME foreign key (DAY_FK)
      references DAY (DAY_ID) on delete restrict on update restrict;

alter table MEAL_NUTRITION add constraint FK_IS_IN foreign key (NUTRITION_FK)
      references NUTRITION (NUTRITION_ID) on delete restrict on update restrict;

alter table MEAL_NUTRITION add constraint FK_POSSESSES foreign key (MEAL_FK)
      references MEAL (MEAL_ID) on delete restrict on update restrict;

alter table TROPHY_USER add constraint FK_ACHIEVES foreign key (USER_FK)
      references USER (USER_ID) on delete restrict on update restrict;

alter table TROPHY_USER add constraint FK_DESCRIBES foreign key (TROPHY_FK)
      references TROPHY (TROPHY_ID) on delete restrict on update restrict;

alter table WORKOUT_ROUTINE add constraint FK_CREATES foreign key (GOAL_FK)
      references GOAL (GOAL_ID) on delete restrict on update restrict;

alter table WORKOUT_ROUTINE add constraint FK_LABELS foreign key (CATEGORY_FK)
      references CATEGORY (CATEGORY_ID) on delete restrict on update restrict;

alter table WORKOUT_ROUTINE_EXERCISE add constraint FK_COMPOSING foreign key (EXERCISE_FK)
      references EXERCISE (EXERCISE_ID) on delete restrict on update restrict;

alter table WORKOUT_ROUTINE_EXERCISE add constraint FK_INCLUDES foreign key (WORKOUT_ROUTINE_FK)
      references WORKOUT_ROUTINE (WORKOUT_ROUTINE_ID) on delete restrict on update restrict;

