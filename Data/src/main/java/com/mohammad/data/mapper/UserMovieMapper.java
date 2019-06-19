package com.mohammad.data.mapper;

import com.mohammad.data.model.UserMovieEntity;
import com.mohammad.domain.model.UserMovieModel;

import javax.inject.Inject;

public class UserMovieMapper implements EntityMapper<UserMovieEntity, UserMovieModel> {

    @Inject
    UserMovieMapper(){}

    @Override
    public UserMovieModel mapFromEntity(UserMovieEntity mEntity) {
        return new UserMovieModel<Object>(mEntity.getTitle(),mEntity.getImdbId(),
                mEntity.getCountry(),mEntity.getYear(),mEntity.getDirector(),
                mEntity.getImdbRating(),mEntity.getImdbVotes(),mEntity.getPoster());
    }

    @Override
    public UserMovieEntity mapToEntity(UserMovieModel mDomain) {
        return new UserMovieEntity<Object>(mDomain.getTitle(),mDomain.getImdbId(),
                mDomain.getCountry(),mDomain.getYear(),mDomain.getDirector(),
                mDomain.getImdbRating(),mDomain.getImdbVotes(),mDomain.getPoster());
    }
}
