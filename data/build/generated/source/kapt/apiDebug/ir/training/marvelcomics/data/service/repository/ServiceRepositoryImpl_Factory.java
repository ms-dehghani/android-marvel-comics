package ir.training.marvelcomics.data.service.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import ir.training.marvelcomics.data.service.repository.api.ApiService;
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

  public ServiceRepositoryImpl_Factory(Provider<ApiService> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public ServiceRepositoryImpl get() {
    return newInstance(apiProvider.get());
  }

  public static ServiceRepositoryImpl_Factory create(Provider<ApiService> apiProvider) {
    return new ServiceRepositoryImpl_Factory(apiProvider);
  }

  public static ServiceRepositoryImpl newInstance(ApiService api) {
    return new ServiceRepositoryImpl(api);
  }
}
