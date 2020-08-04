package com.fit.h4.importguide;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Stone (300482)
 * @version 1.0
 * @since 2020-07-23
 */
//@Component
//不加@Component不会实例化MyClass
public class MyClass implements ImportSelector {

    @Override
    //会实例化返回的类
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.fit.h4.importguide.ByImportSelectorBean"};
    }
}
