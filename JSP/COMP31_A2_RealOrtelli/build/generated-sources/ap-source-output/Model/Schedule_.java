package Model;

import Model.Events;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-21T14:55:47")
@StaticMetamodel(Schedule.class)
public class Schedule_ { 

    public static volatile SingularAttribute<Schedule, String> employeeName;
    public static volatile SingularAttribute<Schedule, Events> eventId;
    public static volatile SingularAttribute<Schedule, String> scheduledDay;
    public static volatile SingularAttribute<Schedule, Date> startTime;
    public static volatile SingularAttribute<Schedule, Date> endTime;
    public static volatile SingularAttribute<Schedule, Integer> scheduleId;

}