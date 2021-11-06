package com.teamo.shredengine.model;

public class Mesh {

    private final int vaoId;
    private final int iboId;
    private final int indexCount;

    public Mesh(int vaoId, int iboId, int indexCount) {
        this.vaoId = vaoId;
        this.iboId = iboId;
        this.indexCount = indexCount;
    }

    public int getVaoId() {
        return vaoId;
    }

    public int getIboId() {
        return iboId;
    }

    public int getIndexCount() {
        return indexCount;
    }
}
