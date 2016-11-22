package common;

import common.IComplexObject;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author <a href="mailto:jesse.sightler@gmail.com">Jesse Sightler</a>
 */
public class ComplexObject implements IComplexObject, Serializable
{
    public String getID()
    {
        String uuid = UUID.randomUUID().toString();
        System.out.println("GetID called, returning: " + uuid);
        return uuid;
    }
}
