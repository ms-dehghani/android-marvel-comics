package ir.training.marvelcomics.data.item.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ir.training.marvelcomics.data.item.dataprovider.ComicItemDataProvider;
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
public final class ComicItemRepositoryImpl_Factory implements Factory<ComicItemRepositoryImpl> {
  private final Provider<ComicItemDataProvider> dataProvider;

  public ComicItemRepositoryImpl_Factory(Provider<ComicItemDataProvider> dataProvider) {
    this.dataProvider = dataProvider;
  }

  @Override
  public ComicItemRepositoryImpl get() {
    return newInstance(dataProvider.get());
  }

  public static ComicItemRepositoryImpl_Factory create(
      Provider<ComicItemDataProvider> dataProvider) {
    return new ComicItemRepositoryImpl_Factory(dataProvider);
  }

  public static ComicItemRepositoryImpl newInstance(ComicItemDataProvider dataProvider) {
    return new ComicItemRepositoryImpl(dataProvider);
  }
}
