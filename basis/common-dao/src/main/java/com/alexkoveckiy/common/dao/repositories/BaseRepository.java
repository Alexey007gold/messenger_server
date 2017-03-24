package com.alexkoveckiy.common.dao.repositories;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * Created by alex on 16.03.17.
 */
@NoRepositoryBean
public interface BaseRepository<E> extends PagingAndSortingRepository<E, String> {
}
