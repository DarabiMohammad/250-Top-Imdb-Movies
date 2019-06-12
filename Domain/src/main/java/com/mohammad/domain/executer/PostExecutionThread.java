package com.mohammad.domain.executer;

import io.reactivex.Scheduler;

public interface PostExecutionThread {
    Scheduler getScheduler() ;
}
