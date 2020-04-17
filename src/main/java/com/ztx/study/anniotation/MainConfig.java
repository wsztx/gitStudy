package com.ztx.study.anniotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(value={"com.ztx.study.anniotation"})
@Import(value={Red.class,Blue.class})
public class MainConfig {
}
