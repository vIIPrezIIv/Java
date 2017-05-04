package Model;

import Model.Schedule;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-21T14:55:47")
@StaticMetamodel(Events.class)
public class Events_ { 

    public static volatile CollectionAttribute<Events, Schedule> scheduleCollection;
    public static volatile SingularAttribute<Events, Integer> eventId;
    public static volatile SingularAttribute<Events, Date> eventDay;
    public static volatile SingularAttribute<Events, Date> eventEndTime;
    public static volatile SingularAttribute<Events, String> eventName;
    public static volatile SingularAttribute<Events, String> equipment;
    public static volatile SingularAttribute<Events, Date> eventStartTime;
    public static volatile SingularAttribute<Events, String> location;

}