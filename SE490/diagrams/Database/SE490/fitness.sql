/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     10/7/2023 4:59:34 PM                         */
/*==============================================================*/


drop table if exists CATEGORY;

drop table if exists DAY;

drop table if exists EXERCISE;

drop table if exists EXERCISE_STATS;

drop table if exists FOOD;

drop table if exists FOOD_MEAL;

drop table if exists GOAL;

drop table if exists MEAL;

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
   CATEGORY_NAME        text,
   CATEGORY_DESCRIPTION text,
   primary key (CATEGORY_ID)
);

/*==============================================================*/
/* Table: DAY                                                   */
/*==============================================================*/
create table DAY
(
   DAY_ID               int not null AUTO_INCREMENT,
   FK_NUTRITION_ID      int not null,
   FK_USER_ID           int not null,
   WORKOUT_ROUTINE_ID   int,
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
   FK_EXERCISE_STATS_ID int,
   FK_CATEGORY_ID       int not null,
   EXERCISE_NAME        text,
   EXERCISE_DESCRIPTION text,
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
   "SET"                int,
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
   FK_NUTRITION_ID      int not null,
   FOOD_NAME            text,
   FOOD_GROUP           text,
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
   FK_MEAL_ID           int not null,
   FK_FOOD_ID           int not null,
   primary key (FOOD_MEAL_ID)
);

/*==============================================================*/
/* Table: GOAL                                                  */
/*==============================================================*/
create table GOAL
(
   GOAL_ID              int not null AUTO_INCREMENT,
   FK_USER_ID           int not null,
   WEIGHT_GOAL          decimal,
   BODY_TYPE_GOAL       text,
   WEEKLY_EXERCISE      int,
   primary key (GOAL_ID)
);

/*==============================================================*/
/* Table: MEAL                                                  */
/*==============================================================*/
create table MEAL
(
   MEAL_ID              int not null AUTO_INCREMENT,
   FK_DAY_ID            int not null,
   FK_NUTRITION_ID      int,
   MEAL_NAME            text,
   IS_DELETED           bool,
   primary key (MEAL_ID)
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
   TROPGY_NAME          text,
   TROPHY_DESCRIPTION   text,
   TROPHY_IMAGE         text,
   primary key (TROPHY_ID)
);

/*==============================================================*/
/* Table: TROPHY_USER                                           */
/*==============================================================*/
create table TROPHY_USER
(
   TROPHY_USER_ID       int not null AUTO_INCREMENT,
   FK_TROPHY_ID         int,
   FK_USER_ID           int,
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
   LAST_NAME            text,
   USERNAME             text,
   PASSWORD             text,
   IS_DELETED           bool,
   FIRST_NAME           text,
   EMAIL                text,
   HEIGHT               decimal,
   WEIGHT               decimal,
   AGE                  int,
   GENDER               text,
   CURRENT_BODY_TYPE    text,
   primary key (USER_ID)
);

/*==============================================================*/
/* Table: WORKOUT_ROUTINE                                       */
/*==============================================================*/
create table WORKOUT_ROUTINE
(
   WORKOUT_ROUTINE_ID   int not null AUTO_INCREMENT,
   FK_CATEGORY_ID       int,
   FK_GOAL_ID           int,
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
   FK_WORKOUT_ROUTINE_ID int,
   FK_EXERCISE_ID       int,
   primary key (WORKOUT_ROUTINE_EXERCISE_ID)
);

alter table DAY add constraint FK_CONSIST foreign key (FK_NUTRITION_ID)
      references NUTRITION (NUTRITION_ID) on delete restrict on update restrict;

alter table DAY add constraint FK_CONSIST_OF foreign key (WORKOUT_ROUTINE_ID)
      references WORKOUT_ROUTINE (WORKOUT_ROUTINE_ID) on delete restrict on update restrict;

alter table DAY add constraint FK_DAY_USER foreign key (FK_USER_ID)
      references USER (USER_ID) on delete restrict on update restrict;

alter table EXERCISE add constraint FK_DETAILS foreign key (FK_EXERCISE_STATS_ID)
      references EXERCISE_STATS (EXERCISE_STATS_ID) on delete restrict on update restrict;

alter table EXERCISE add constraint FK_IS foreign key (FK_CATEGORY_ID)
      references CATEGORY (CATEGORY_ID) on delete restrict on update restrict;

alter table FOOD add constraint FK_HAS foreign key (FK_NUTRITION_ID)
      references NUTRITION (NUTRITION_ID) on delete restrict on update restrict;

alter table FOOD_MEAL add constraint FK_CONTAINS foreign key (FK_MEAL_ID)
      references MEAL (MEAL_ID) on delete restrict on update restrict;

alter table FOOD_MEAL add constraint FK_IS_PART_OF foreign key (FK_FOOD_ID)
      references FOOD (FOOD_ID) on delete restrict on update restrict;

alter table GOAL add constraint FK_MOTIVATES foreign key (FK_USER_ID)
      references USER (USER_ID) on delete restrict on update restrict;

alter table MEAL add constraint FK_CONSUME foreign key (FK_DAY_ID)
      references DAY (DAY_ID) on delete restrict on update restrict;

alter table MEAL add constraint FK_POSSESSES foreign key (FK_NUTRITION_ID)
      references NUTRITION (NUTRITION_ID) on delete restrict on update restrict;

alter table TROPHY_USER add constraint FK_ACHIEVES foreign key (FK_USER_ID)
      references USER (USER_ID) on delete restrict on update restrict;

alter table TROPHY_USER add constraint FK_DESCRIBES foreign key (FK_TROPHY_ID)
      references TROPHY (TROPHY_ID) on delete restrict on update restrict;

alter table WORKOUT_ROUTINE add constraint FK_CREATES foreign key (FK_GOAL_ID)
      references GOAL (GOAL_ID) on delete restrict on update restrict;

alter table WORKOUT_ROUTINE add constraint FK_LABELS foreign key (FK_CATEGORY_ID)
      references CATEGORY (CATEGORY_ID) on delete restrict on update restrict;

alter table WORKOUT_ROUTINE_EXERCISE add constraint FK_COMPOSING foreign key (FK_EXERCISE_ID)
      references EXERCISE (EXERCISE_ID) on delete restrict on update restrict;

alter table WORKOUT_ROUTINE_EXERCISE add constraint FK_INCLUDES foreign key (FK_WORKOUT_ROUTINE_ID)
      references WORKOUT_ROUTINE (WORKOUT_ROUTINE_ID) on delete restrict on update restrict;

