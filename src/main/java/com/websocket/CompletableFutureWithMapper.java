package com.websocket;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class CompletableFutureWithMapper<T> extends CompletableFuture<T> {

    private final Function<GenericAnswer, T> mapper;

    public CompletableFutureWithMapper(Function<GenericAnswer, T> mapper) {
        this.mapper = mapper;
    }

    public boolean completeAndMap(GenericAnswer genericAnswer) {
        return complete(mapper.apply(genericAnswer));
    }
}
