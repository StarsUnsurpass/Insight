package com.example.insight;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = InsightApplication.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface InsightApplication_GeneratedInjector {
  void injectInsightApplication(InsightApplication insightApplication);
}
