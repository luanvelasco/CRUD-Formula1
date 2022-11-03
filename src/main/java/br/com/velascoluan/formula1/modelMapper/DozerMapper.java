package br.com.velascoluan.formula1.modelMapper;


import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerMapper {

    /**
     * Initializing mapper
     */
    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();


    /**
     * @param origin refers to the origin class that must be converted
     * @param destination refers to the target that must be returned
     * @return conversion of simple object
     */
    public static <Origin, Destiny> Destiny parseObject(Origin origin, Class<Destiny> destination){
        return mapper.map(origin, destination);
    }

    /**
     * @param origin refers to the origin class that must be converted
     * @param destination refers to the target that must be returned
     * @return conversion a List of object
     */
    public static <Origin, Destiny> List<Destiny> parseListObject(List<Origin> origin, Class<Destiny> destination){
       List<Destiny> destinationObjects = new ArrayList<Destiny>();
        for (Origin o: origin) {
            destinationObjects.add(mapper.map(o, destination));
        }
        return destinationObjects;
    }
}
