package com.mohammad.presentation.state;

public class Resource<T> {

    private ResourceState mResourceState;
    private T mData;
    private String mMessage ;

    public Resource(ResourceState mResourceState, T mData, String mMessage) {
        this.mResourceState = mResourceState;
        this.mData = mData;
        this.mMessage = mMessage;
    }

    public ResourceState getResourceState() {
        return mResourceState;
    }

    public T getData() {
        return mData;
    }

    public String getMessage() {
        return mMessage;
    }
}
