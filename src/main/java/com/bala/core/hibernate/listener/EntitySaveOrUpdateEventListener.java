/**
 * lostingz
 * Created on 2016年7月11日
 */
package com.bala.core.hibernate.listener;

import org.hibernate.event.internal.DefaultSaveOrUpdateEventListener;
import org.hibernate.event.spi.SaveOrUpdateEvent;

/**
 * @author lostingz<a href="mailto:18710833123@163.com">lostingz</a>
 * @version $Id$
 */
public class EntitySaveOrUpdateEventListener extends DefaultSaveOrUpdateEventListener {

    @Override
    public void onSaveOrUpdate(SaveOrUpdateEvent event) {
        System.out.println("execute save or update start");
        super.onSaveOrUpdate(event);
        System.out.println("execute save or update finish");
    }
}
