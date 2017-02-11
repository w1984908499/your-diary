package sunxl8.your_diary.db.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import sunxl8.your_diary.db.entity.ItemEntity;
import sunxl8.your_diary.db.entity.MemoEntity;

import sunxl8.your_diary.db.dao.ItemEntityDao;
import sunxl8.your_diary.db.dao.MemoEntityDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig itemEntityDaoConfig;
    private final DaoConfig memoEntityDaoConfig;

    private final ItemEntityDao itemEntityDao;
    private final MemoEntityDao memoEntityDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        itemEntityDaoConfig = daoConfigMap.get(ItemEntityDao.class).clone();
        itemEntityDaoConfig.initIdentityScope(type);

        memoEntityDaoConfig = daoConfigMap.get(MemoEntityDao.class).clone();
        memoEntityDaoConfig.initIdentityScope(type);

        itemEntityDao = new ItemEntityDao(itemEntityDaoConfig, this);
        memoEntityDao = new MemoEntityDao(memoEntityDaoConfig, this);

        registerDao(ItemEntity.class, itemEntityDao);
        registerDao(MemoEntity.class, memoEntityDao);
    }
    
    public void clear() {
        itemEntityDaoConfig.clearIdentityScope();
        memoEntityDaoConfig.clearIdentityScope();
    }

    public ItemEntityDao getItemEntityDao() {
        return itemEntityDao;
    }

    public MemoEntityDao getMemoEntityDao() {
        return memoEntityDao;
    }

}