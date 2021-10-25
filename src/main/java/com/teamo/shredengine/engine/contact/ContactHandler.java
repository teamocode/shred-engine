package com.teamo.shredengine.engine.contact;

public class ContactHandler implements ContactHandlerType {

    @Override
    public boolean isContacting(Contactable firstContactable,
                                Contactable secondContactable) {
        // Get object A and object B positions and radius
        float aX = firstContactable.getPosition().x;
        float aY = firstContactable.getPosition().y;
        float radiusA = firstContactable.getRadius();

        float bX = secondContactable.getPosition().x;
        float bY = secondContactable.getPosition().y;
        float radiusB = secondContactable.getRadius();

        // Find the distance between A and B
        float dX = Math.abs(bX - aX);
        float dY = Math.abs(bY - aY);
        double distance = Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2));

        // Determine if colliding
        return distance <= (radiusA + radiusB);
    }
}

