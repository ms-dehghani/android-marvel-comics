package ir.training.marvelcomics.data.service.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ir.training.marvelcomics.data.service.repository.api.ApiService;
import ir.training.marvelcomics.data.service.repository.db.dao.ComicDao;
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
public final class ServiceRepositoryImpl_Factory implements Factory<ServiceRepositoryImpl> {
  private final Provider<ApiService> apiProvider;

  private final Provider<ComicDao> comicDaoProvider;

  public ServiceRepositoryImpl_Factory(Provider<ApiService> apiProvider,
      Provider<ComicDao> comicDaoProvider) {
    this.apiProvider = apiProvider;
    this.comicDaoProvider = comicDaoProvider;
  }

  @Override
  public ServiceRepositoryImpl get() {
    return newInstance(apiProvider.get(), comicDaoProvider.get());
  }

  public static ServiceRepositoryImpl_Factory create(Provider<ApiService> apiProvider,
      Provider<ComicDao> comicDaoProvider) {
    return new ServiceRepositoryImpl_Factory(apiProvider, comicDaoProvider);
  }

  public static ServiceRepositoryImpl newInstance(ApiService api, ComicDao comicDao) {
    return new ServiceRepositoryImpl(api, comicDao);
  }
}
