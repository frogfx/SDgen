package au.com.anthonybruno.defintion;

import au.com.anthonybruno.generator.Generator;

public interface FieldDefinition {

    FileTypeDefinition use(Class<?> c);

    FileTypeDefinition addField(String name, Generator generator);
}