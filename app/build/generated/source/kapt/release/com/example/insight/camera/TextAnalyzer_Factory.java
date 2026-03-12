package com.example.insight.camera;

import com.google.mlkit.vision.text.TextRecognizer;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class TextAnalyzer_Factory implements Factory<TextAnalyzer> {
  private final Provider<TextRecognizer> recognizerProvider;

  public TextAnalyzer_Factory(Provider<TextRecognizer> recognizerProvider) {
    this.recognizerProvider = recognizerProvider;
  }

  @Override
  public TextAnalyzer get() {
    return newInstance(recognizerProvider.get());
  }

  public static TextAnalyzer_Factory create(Provider<TextRecognizer> recognizerProvider) {
    return new TextAnalyzer_Factory(recognizerProvider);
  }

  public static TextAnalyzer newInstance(TextRecognizer recognizer) {
    return new TextAnalyzer(recognizer);
  }
}
