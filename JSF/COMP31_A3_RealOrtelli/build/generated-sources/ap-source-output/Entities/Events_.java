package Entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T12:02:14")
@StaticMetamodel(Events.class)
public class Events_ { 

    public static volatile SingularAttribute<Events, Integer> eventId;
    public static volatile SingularAttribute<Events, Date> eventDay;
    public static volatile SingularAttribute<Events, Date> eventEndTime;
    public static volatile SingularAttribute<Events, String> eventName;
    public static volatile SingularAttribute<Events, String> equipment;
    public static volatile SingularAttribute<Events, Date> eventStartTime;
    public static volatile SingularAttribute<Events, String> location;
    public static volatile SingularAttribute<Events, Date> eventMonth;

}