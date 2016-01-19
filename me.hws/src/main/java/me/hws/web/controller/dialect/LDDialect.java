package me.hws.web.controller.dialect;

import java.util.HashSet;
import java.util.Set;

import me.hws.web.controller.dialect.processor.CategoriesElementProcessor;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.processor.IProcessor;

public class LDDialect extends AbstractDialect {

	@Override
	public String getPrefix() {
		return "ld";
	}
	
    @Override
    public Set<IProcessor> getProcessors() {
        final Set<IProcessor> processors = new HashSet<IProcessor>();
        processors.add(new CategoriesElementProcessor());
        return processors;
    }


}
