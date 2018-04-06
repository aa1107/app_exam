package com.example.a501_03.greendao;


import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Property;
import org.greenrobot.greendao.generator.Schema;
import org.greenrobot.greendao.generator.ToMany;

public class MyGenerator {
    public static void main(String[] args){
        Schema schema=new Schema(1,"com.example.a501_03.app_class_portfolio_leejanghee0330.db");
        schema.enableKeepSectionsByDefault();

        setRelation(addTripEntites(schema),addScheduleEntites(schema),addPlaceEntites(schema));

        try{
            new DaoGenerator().generateAll(schema,"../app/src/main/java");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void setRelation(Entity trip,Entity schedule, Entity place){
        Property place_id = schedule.addLongProperty("place_id").notNull().getProperty();
        schedule.addToOne(place,place_id);

        Property trip_id=schedule.addLongProperty("trip_id").notNull().getProperty();
        ToMany toMany=schedule.addToMany(schedule,trip_id);
        toMany.setName("schedules");
    }

    private static Entity addPlaceEntites(final Schema schema){
        Entity place=schema.addEntity("Place");
        place.addIdProperty().primaryKey().autoincrement();
        place.addDateProperty("created_at").notNull();
        place.addDateProperty("updated_at").notNull();
        place.addStringProperty("name");
        place.addStringProperty("desc");
        place.addStringProperty("img_name");
        place.addStringProperty("phone");
        return place;
    }

    private static Entity addTripEntites(final Schema schema){
        Entity travel=schema.addEntity("travel");
        travel.addIdProperty().primaryKey().autoincrement();
        travel.addDateProperty("created_at").notNull();
        travel.addDateProperty("updated_at").notNull();
        travel.addStringProperty("title");
        travel.addDateProperty("start_day");
        travel.addDateProperty("end_day");
        travel.addIntProperty("number_of_member");
        travel.addLongProperty("total_money");
        return travel;
    }

    private static Entity addScheduleEntites(final Schema schema){
        Entity schedule=schema.addEntity("Schedule");
        schedule.addIdProperty().primaryKey().autoincrement();
        schedule.addDateProperty("created_at").notNull();
        schedule.addDateProperty("updated_at").notNull();
        schedule.addStringProperty("place_name");
        schedule.addDateProperty("visit_time");
        schedule.addDateProperty("elapse_time");
        schedule.addLongProperty("spend_money");
        return schedule;
    }

}