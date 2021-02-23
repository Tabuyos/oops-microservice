package com.tabuyos.microservice.oops.common.core.support;

import com.tabuyos.microservice.oops.common.base.exception.BusinessException;
import com.tabuyos.microservice.oops.common.zk.generator.IncrementIdGenerator;
import com.tabuyos.microservice.oops.common.zk.generator.UniqueIdGenerator;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * <p>Description: </p>
 * <pre>
 *   <b>project: </b><i>tabuyos-microservice</i>
 *   <b>package: </b><i>com.tabuyos.microservice.oops.common.core.support</i>
 *   <b>class: </b><i>BaseService</i>
 *   comment here.
 * </pre>
 *
 * @author <pre><b>username: </b><i><a href="http://www.tabuyos.com">Tabuyos</a></i></pre>
 * <pre><b>site: </b><i><a href="http://www.tabuyos.com">http://www.tabuyos.com</a></i></pre>
 * <pre><b>email: </b><i>tabuyos@outlook.com</i></pre>
 * <pre><b>description: </b><i>
 *   <pre>
 *     Talk is cheap, show me the code.
 *   </pre>
 * </i></pre>
 * @version 0.1.0
 * @since 0.1.0 - 2/22/21 1:33 PM
 */
public abstract class BaseService<T> implements IService<T> {


  /**
   * The Logger.
   */
  protected final Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * The Mapper.
   */
  @Autowired
  protected Mapper<T> mapper;

  /**
   * Gets mapper.
   *
   * @return the mapper
   */
  public Mapper<T> getMapper() {
    return mapper;
  }

  /**
   * Select list.
   *
   * @param record the record
   *
   * @return the list
   */
  @Override
  public List<T> select(T record) {
    return mapper.select(record);
  }

  /**
   * Select by key t.
   *
   * @param key the key
   *
   * @return the t
   */
  @Override
  public T selectByKey(Object key) {
    return mapper.selectByPrimaryKey(key);
  }

  /**
   * Select all list.
   *
   * @return the list
   */
  @Override
  public List<T> selectAll() {
    return mapper.selectAll();
  }

  /**
   * Select one t.
   *
   * @param record the record
   *
   * @return the t
   */
  @Override
  public T selectOne(T record) {
    return mapper.selectOne(record);
  }

  /**
   * Select count int.
   *
   * @param record the record
   *
   * @return the int
   */
  @Override
  public int selectCount(T record) {
    return mapper.selectCount(record);
  }

  /**
   * Select by example list.
   *
   * @param example the example
   *
   * @return the list
   */
  @Override
  public List<T> selectByExample(Object example) {
    return mapper.selectByExample(example);
  }

  /**
   * Save int.
   *
   * @param record the record
   *
   * @return the int
   */
  @Override
  public int save(T record) {
    return mapper.insertSelective(record);
  }

  /**
   * Batch save int.
   *
   * @param list the list
   *
   * @return the int
   */
  @Override
  public int batchSave(List<T> list) {
    int result = 0;
    for (T record : list) {
      int count = mapper.insertSelective(record);
      result += count;
    }
    return result;
  }

  /**
   * Update int.
   *
   * @param entity the entity
   *
   * @return the int
   */
  @Override
  public int update(T entity) {
    return mapper.updateByPrimaryKeySelective(entity);
  }

  /**
   * Delete int.
   *
   * @param record the record
   *
   * @return the int
   */
  @Override
  public int delete(T record) {
    return mapper.delete(record);
  }

  /**
   * Delete by key int.
   *
   * @param key the key
   *
   * @return the int
   */
  @Override
  public int deleteByKey(Object key) {
    return mapper.deleteByPrimaryKey(key);
  }

  /**
   * Batch delete int.
   *
   * @param list the list
   *
   * @return the int
   */
  @Override
  public int batchDelete(List<T> list) {
    int result = 0;
    for (T record : list) {
      int count = mapper.delete(record);
      if (count < 1) {
        logger.error("删除数据失败");
        throw new BusinessException("删除数据失败!");
      }
      result += count;
    }
    return result;
  }

  /**
   * Select count by example int.
   *
   * @param example the example
   *
   * @return the int
   */
  @Override
  public int selectCountByExample(Object example) {
    return mapper.selectCountByExample(example);
  }

  /**
   * Update by example int.
   *
   * @param record  the record
   * @param example the example
   *
   * @return the int
   */
  @Override
  public int updateByExample(T record, Object example) {
    return mapper.updateByExampleSelective(record, example);
  }

  /**
   * Delete by example int.
   *
   * @param example the example
   *
   * @return the int
   */
  @Override
  public int deleteByExample(Object example) {
    return mapper.deleteByPrimaryKey(example);
  }

  /**
   * Select by row bounds list.
   *
   * @param record    the record
   * @param rowBounds the row bounds
   *
   * @return the list
   */
  @Override
  public List<T> selectByRowBounds(T record, RowBounds rowBounds) {
    return mapper.selectByRowBounds(record, rowBounds);
  }

  /**
   * Select by example and row bounds list.
   *
   * @param example   the example
   * @param rowBounds the row bounds
   *
   * @return the list
   */
  @Override
  public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
    return mapper.selectByExampleAndRowBounds(example, rowBounds);
  }

  protected long generateId() {
    return UniqueIdGenerator.getInstance(IncrementIdGenerator.getServiceId()).nextId();
  }
}
