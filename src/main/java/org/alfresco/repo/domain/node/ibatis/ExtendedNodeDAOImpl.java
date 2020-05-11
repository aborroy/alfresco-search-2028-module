/*
 * #%L
 * Alfresco Repository
 * %%
 * Copyright (C) 2005 - 2019 Alfresco Software Limited
 * %%
 * This file is part of the Alfresco software. 
 * If the software was purchased under a paid Alfresco license, the terms of 
 * the paid license agreement will prevail.  Otherwise, the software is 
 * provided under the following open source license terms:
 * 
 * Alfresco is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Alfresco is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alfresco. If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */
package org.alfresco.repo.domain.node.ibatis;

import org.mybatis.spring.SqlSessionTemplate;

/**
 * iBatis-specific extension of the Node abstract DAO
 * 
 * Includes additional operations to default NodeDAOImpl
 *  
 * @author aborroy
 *
 */
public class ExtendedNodeDAOImpl extends NodeDAOImpl
{
    // Entry ids in node-extended-SqlMap.xml 
    private static final String SELECT_TXN_NEXT_TXN_COMMIT_TIME = "select_TxnNextTxnCommitTime";
    
    private SqlSessionTemplate template;
    
    /**
     * Gets the next commit time from [fromCommitTime]
     * 
     * @param fromCommitTime Initial commit time
     * @return next commit time
     */
    public Long getNextTxCommitTime(Long fromCommitTime)
    {
        FromCommitTimeEntity fromCommitTimeEntity = new FromCommitTimeEntity();
        fromCommitTimeEntity.setFromCommitTime(fromCommitTime);
        
        return template.selectOne(SELECT_TXN_NEXT_TXN_COMMIT_TIME, fromCommitTimeEntity);
    }

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) 
    {
        this.template = sqlSessionTemplate;
    }
}
