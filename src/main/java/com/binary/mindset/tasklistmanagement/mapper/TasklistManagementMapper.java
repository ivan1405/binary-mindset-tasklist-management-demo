package com.binary.mindset.tasklistmanagement.mapper;

import com.binary.mindset.tasklistmanagement.crud.entity.ProjectEntity;
import com.binary.mindset.tasklistmanagement.crud.entity.TaskEntity;
import com.binary.mindset.tasklistmanagement.mapper.converter.LocalDateConverter;
import com.binary.mindset.tasklistmanagement.model.Project;
import com.binary.mindset.tasklistmanagement.model.Task;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.OrikaSystemProperties;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;

import static com.binary.mindset.tasklistmanagement.mapper.converter.LocalDateConverter.LOCALDATE_TO_TIMESTAMP_CONVERTER_ID;

@Component
public class TasklistManagementMapper extends ConfigurableMapper {

    @Override
    protected void configureFactoryBuilder(DefaultMapperFactory.Builder factoryBuilder) {
        super.configureFactoryBuilder(factoryBuilder);

        System.setProperty(OrikaSystemProperties.WRITE_SOURCE_FILES, "true");
        System.setProperty(OrikaSystemProperties.WRITE_CLASS_FILES, "true");
    }

    @Override
    protected void configure(MapperFactory mapperFactory) {
        super.configure(mapperFactory);

        // project mapping
        mapperFactory.classMap(ProjectEntity.class, Project.class)
                .field("id", "projectId")
                .byDefault()
                .register();

        // task mapping
        mapperFactory.classMap(TaskEntity.class, Task.class)
                .field("id", "taskId")
                .field("title", "information.title")
                .field("description", "information.description")
                .fieldMap("createdOn", "creationDate").converter(LOCALDATE_TO_TIMESTAMP_CONVERTER_ID).add()
                .fieldMap("lastModified", "modificationDate").converter(LOCALDATE_TO_TIMESTAMP_CONVERTER_ID).add()
                .byDefault()
                .register();

        // Converters
        mapperFactory.getConverterFactory().registerConverter(LOCALDATE_TO_TIMESTAMP_CONVERTER_ID, new LocalDateConverter());
    }

}
