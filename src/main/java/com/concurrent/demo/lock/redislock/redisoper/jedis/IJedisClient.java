package com.concurrent.demo.lock.redislock.redisoper.jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.BitOP;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.Tuple;
import redis.clients.jedis.ZParams;
import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.params.sortedset.ZAddParams;
import redis.clients.jedis.params.sortedset.ZIncrByParams;

/**
 * Jedis 客户端
 *
 * @author    niugk
 * @version   2018-05-18
 * */
public interface IJedisClient {

    public Jedis getResource();

    /**
     * keys pattern
     * 查看所有主键
     * @param byte[] pattern
     *               * 代表匹配任意字符
     *               ? 代表匹配一个字符
     *               [] 代表匹配部分字符,例如 [1,3] 匹配 1,3  [1-10] 匹配1到10
     *               \x 用来做转义
     * @return Set<byte[]>
     * */
    @Deprecated
    public Set<byte[]> keys(byte[] pattern);


    /**
     * keys pattern
     * 查看所有主键
     * @param String pattern
     *               * 代表匹配任意字符
     *               ? 代表匹配一个字符
     *               [] 代表匹配部分字符,例如 [1,3] 匹配 1,3  [1-10] 匹配1到10
     *               \x 用来做转义
     * @return Set<String>
     * */
    @Deprecated
    public Set<String> keys(String pattern);

    /**
     * scan cursor
     * 渐进式遍历键
     * @param byte[] cursor
     * @return ScanResult<byte[]>
     * */
    public ScanResult<byte[]> scan(byte[] cursor);

    /**
     * scan cursor [match pattern] [count number]
     * 渐进式遍历键
     * @param byte[] cursor
     * @param ScanParams params
     * @return ScanResult<byte[]>
     * */
    public ScanResult<byte[]> scan(byte[] cursor, ScanParams params);

    /**
     * scan cursor
     * 渐进式遍历键
     * @param int cursor
     * @return ScanResult<String>
     * */
    @Deprecated
    public ScanResult<String> scan(int cursor);

    /**
     * scan cursor [match pattern] [count number]
     * 渐进式遍历键
     * @param int cursor
     * @param ScanParams params
     * @return ScanResult<String>
     * */
    @Deprecated
    public ScanResult<String> scan(int cursor, ScanParams params);

    /**
     * scan cursor
     * 渐进式遍历键
     * @param String cursor
     * @return ScanResult<String>
     * */
    public ScanResult<String> scan(String cursor);

    /**
     * scan cursor [match pattern] [count number]
     * 渐进式遍历键
     * @param String cursor
     * @param ScanParams params
     * @return ScanResult<String>
     * */
    public ScanResult<String> scan(String cursor, ScanParams params);

    /**
     * dbsize
     * 查看键总数
     * @return Long
     * */
    public Long dbSize();

    /**
     * exists key
     * 检查键是否存在
     * @param  byte[] key
     * @return Boolean
     * */
    public Boolean exists(byte[] key);

    /**
     * exists key
     * 检查键是否存在
     * @param  byte[]... keys
     * @return Long
     * */
    public Long exists(byte[]... keys);

    /**
     * exists key
     * 检查键是否存在
     * @param  String key
     * @return Boolean
     * */
    public Boolean exists(String key);

    /**
     * exists key
     * 检查键是否存在
     * @param  String... keys
     * @return Long
     * */
    public Long exists(String... keys);

    /**
     * type key
     * 键的数据结构类型
     * @param  byte[] key
     * @return String
     *                1) string    字符串
     *                2) hash      哈希
     *                3) list      列表
     *                4) set       集合
     *                5) zset      有序集合
     * */
    public String type(byte[] key);

    /**
     * type key
     * 键的数据结构类型
     * @param  String key
     * @return String
     *                1) string    字符串
     *                2) hash      哈希
     *                3) list      列表
     *                4) set       集合
     *                5) zset      有序集合
     * */
    public String type(String key);

    /**
     * object encoding key
     * 查看内部编码
     * @param  byte[] key
     * @return byte[]
     * */
    public byte[] objectEncoding(byte[] key);

    /**
     * object encoding key
     * 查看内部编码
     * @param  String key
     * @return String
     * */
    public String objectEncoding(String key);

    /**
     * sort key
     * 返回或保存给定列表、集合、有序集合 key 中经过排序的元素。
     * @param  byte[] key
     * @return List<byte[]>
     * */
    public List<byte[]> sort(byte[] key);

    /**
     * sort key
     * 返回或保存给定列表、集合、有序集合 key 中经过排序的元素。
     * @param  String key
     * @return List<String>
     * */
    public List<String> sort(String key);

    /**
     * sort key [by pattern] [limit offset count] [get pattern [get pattern ...]] [asc | desc] [alpha]
     * 返回或保存给定列表、集合、有序集合 key 中经过排序的元素。
     * @param  byte[] key
     * @return List<byte[]>
     * */
    public List<byte[]> sort(byte[] key, SortingParams sortingParameters);

    /**
     * sort key [by pattern] [limit offset count] [get pattern [get pattern ...]] [asc | desc] [alpha]
     * 返回或保存给定列表、集合、有序集合 key 中经过排序的元素。
     * @param  String key
     * @return List<String>
     * */
    public List<String> sort(String key, SortingParams sortingParameters);

    /**
     * sort key [store destination]
     * 返回或保存给定列表、集合、有序集合 key 中经过排序的元素。
     * @param  byte[] key
     * @param  byte[] dstkey
     * @return Long
     * */
    public Long sort(byte[] key, byte[] dstkey);

    /**
     * sort key [store destination]
     * 返回或保存给定列表、集合、有序集合 key 中经过排序的元素。
     * @param  String key
     * @param  String dstkey
     * @return Long
     * */
    public Long sort(String key, String dstkey);

    /**
     * sort key [by pattern] [limit offset count] [get pattern [get pattern ...]] [asc | desc] [alpha] [store destination]
     * 返回或保存给定列表、集合、有序集合 key 中经过排序的元素。
     * @param  byte[] key
     * @return Long
     * */
    public Long sort(byte[] key, SortingParams sortingParameters, byte[] dstkey);

    /**
     * sort key [by pattern] [limit offset count] [get pattern [get pattern ...]] [asc | desc] [alpha] [store destination]
     * 返回或保存给定列表、集合、有序集合 key 中经过排序的元素。
     * @param  String key
     * @return Long
     * */
    public Long sort(String key, SortingParams sortingParameters, String dstkey);

    /**
     * rename key newkey
     * 键重命名
     * @param  byte[] oldkey
     * @param  byte[] newkey
     * @return String
     * */
    public String rename(byte[] oldkey, byte[] newkey);

    /**
     * rename key newkey
     * 键重命名
     * @param  String oldkey
     * @param  String newkey
     * @return String
     * */
    public String rename(String oldkey, String newkey);

    /**
     * renamenx key newkey
     * 键重命名
     * @param  byte[] oldkey
     * @param  byte[] newkey
     * @return Long
     * */
    public Long renamenx(byte[] oldkey, byte[] newkey);

    /**
     * rename key newkey
     * 键重命名
     * @param  String oldkey
     * @param  String newkey
     * @return Long
     * */
    public Long renamenx(String oldkey, String newkey);

    /**
     * randomKey
     * 随机返回一个键
     * @return String
     * */
    public String randomKey(byte[] oldkey, byte[] newkey);

    /**
     * 切换数据库
     * 迁移键
     * @param  int dbIndex
     * @return String
     * */
    public String select(int dbIndex);

    /**
     * move key db
     * 迁移键
     * @param  byte[] key
     * @param  int dbIndex
     * @return Long
     * */
    public Long move(byte[] key, int dbIndex);

    /**
     * move key db
     * 迁移键
     * @param  String key
     * @param  int dbIndex
     * @return Long
     * */
    public Long move(String key, int dbIndex);

    /**
     * dump key
     * 迁移键
     * @param  byte[] key
     * @return byte[]
     * */
    public byte[] dump(byte[] key);

    /**
     * dump key
     * 迁移键
     * @param  String key
     * @return byte[]
     * */
    public byte[] dump(String key);

    /**
     * restore key ttl value
     * 迁移键
     * @param  byte[] key
     * @param  int ttl
     * @param  byte[] serializedValue
     * @return String
     * */
    public String restore(byte[] key, int ttl, byte[] serializedValue);

    /**
     * restore key ttl value
     * 迁移键
     * @param  String key
     * @param  int ttl
     * @param  byte[] serializedValue
     * @return String
     * */
    public String restore(String key, int ttl, byte[] serializedValue);

    /**
     * migrate host port key|"" destination-db timeout
     * 迁移键
     * @param  byte[] host
     * @param  int port
     * @param  byte[] key
     * @param  int destinationDb
     * @param  int timeout
     * @return String
     * */
    public String migrate(byte[] host, int port, byte[] key, int destinationDb, int timeout);

    /**
     * migrate host port key|"" destination-db timeout
     * 迁移键
     * @param  String host
     * @param  int port
     * @param  String key
     * @param  int destinationDb
     * @param  int timeout
     * @return String
     * */
    public String migrate(String host, int port, String key, int destinationDb, int timeout);

    /**
     * del key
     * 删除键
     * @param  byte[] key
     * @return Long
     * */
    public Long del(byte[] key);

    /**
     * del key
     * 删除键
     * @param  byte[]... keys
     * @return Long
     * */
    public Long del(byte[]... keys);

    /**
     * del key
     * 删除键
     * @param  String key
     * @return Long
     * */
    public Long del(String key);

    /**
     * del key
     * 删除键
     * @param  String... keys
     * @return Long
     * */
    public Long del(String... keys);

    /**
     * expire key seconds
     * 键过期
     * 添加过期时间,过期自动删除
     * @param  byte[] keys
     * @param  int seconds (单位:秒)
     * @return Long
     * */
    public Long expire(byte[] key, int seconds);

    /**
     * expire key seconds
     * 键过期
     * 添加过期时间,过期自动删除
     * @param  String keys
     * @param  int seconds (单位:秒)
     * @return Long
     * */
    public Long expire(String key, int seconds);

    /**
     * pexpire key milliseconds
     * 键过期
     * 添加过期时间,过期自动删除
     * @param  byte[] keys
     * @param  int milliseconds (单位:毫秒)
     * @return Long
     * */
    @Deprecated
    public Long pexpire(byte[] key, int milliseconds);

    /**
     * pexpire key milliseconds
     * 键过期
     * 添加过期时间,过期自动删除
     * @param  String keys
     * @param  int milliseconds (单位:毫秒)
     * @return Long
     * */
    @Deprecated
    public Long pexpire(String key, int milliseconds);

    /**
     * expireat key timestamp
     * 键过期
     * 指定过期时间,过期自动删除
     * @param  byte[] keys
     * @param  long unixTime (秒级时间戳)
     * @return Long
     * */
    public Long expireAt(byte[] key, long unixTime);

    /**
     * expireat key timestamp
     * 键过期
     * 指定过期时间,过期自动删除
     * @param  String keys
     * @param  long unixTime (秒级时间戳)
     * @return Long
     * */
    public Long expireAt(String key, long unixTime);

    /**
     * expireat key millisecondsTimestamp
     * 键过期
     * 指定过期时间,过期自动删除
     * @param  byte[] keys
     * @param  long millisecondsTimestamp (毫秒级时间戳)
     * @return Long
     * */
    public Long pexpireAt(byte[] key, long millisecondsTimestamp);

    /**
     * pexpireAt key millisecondsTimestamp
     * 键过期
     * 指定过期时间,过期自动删除
     * @param  String keys
     * @param  long millisecondsTimestamp (毫秒级时间戳)
     * @return Long
     * */
    public Long pexpireAt(String key, long millisecondsTimestamp);

    /**
     * ttl key
     * 键过期
     * 查询过期时间
     * @param  byte[] keys
     * @return Long
     *              返回大于等于0的整数:键剩余的过期时间(单位:秒)
     *              返回 -1: 键未设置过期时间
     *              返回 -2: 键不存在
     * */
    public Long ttl(byte[] key);

    /**
     * ttl key
     * 键过期
     * 查询过期时间
     * @param  String keys
     * @return Long
     *              返回大于等于0的整数:键剩余的过期时间(单位:秒)
     *              返回 -1: 键未设置过期时间
     *              返回 -2: 键不存在
     * */
    public Long ttl(String key);

    /**
     * pttl key
     * 键过期
     * 查询过期时间
     * @param  byte[] keys
     * @return Long
     *              返回大于等于0的整数:键剩余的过期时间(单位:毫秒)
     *              返回 -1: 键未设置过期时间
     *              返回 -2: 键不存在
     * */
    public Long pttl(byte[] key);

    /**
     * pttl key
     * 键过期
     * 查询过期时间
     * @param  String keys
     * @return Long
     *              返回大于等于0的整数:键剩余的过期时间(单位:毫秒)
     *              返回 -1: 键未设置过期时间
     *              返回 -2: 键不存在
     * */
    public Long pttl(String key);

    /**
     * persist key
     * 键过期
     * 清楚键有效时间
     * @param  byte[] keys
     * @return Long
     * */
    public Long persist(byte[] key);

    /**
     * persist key
     * 键过期
     * 清楚键有效时间
     * @param  String keys
     * @return Long
     * */
    public Long persist(String key);

    /**
     * set key value
     * 设置值
     * @param  byte[] keys
     * @param  byte[] value
     * @return String
     * */
    public String set(byte[] key, byte[] value);

    /**
     * set key value [nx|xx]
     * 设置值
     * @param  byte[] keys
     * @param  byte[] value
     * @param  byte[] nxxx NX|XX  NX|XX  NX - 只能设置不存在的键    XX - 只能已存在的键
     * @return String
     * */
    public String set(byte[] key, byte[] value, byte[] nxxx);

    /**
     * set key value [ex seconds] [px milliseconds] [nx|xx]
     * 设置值
     * @param  byte[] keys
     * @param  byte[] value
     * @param  byte[] nxxx NX|XX  NX|XX  NX - 只能设置不存在的键    XX - 只能已存在的键
     * @param  byte[] expx EX|PX  EX = 秒; PX = 毫秒
     * @param  int time
     * @return String
     * */
    public String set(byte[] key, byte[] value, byte[] nxxx, byte[] expx, int time);

    /**
     * set key value [ex seconds] [px milliseconds] [nx|xx]
     * 设置值
     * @param  byte[] keys
     * @param  byte[] value
     * @param  byte[] nxxx NX|XX  NX|XX  NX - 只能设置不存在的键    XX - 只能已存在的键
     * @param  byte[] expx EX|PX  EX = 秒; PX = 毫秒
     * @param  int time
     * @return String
     * */
    public String set(byte[] key, byte[] value, byte[] nxxx, byte[] expx, long time);

    /**
     * set key value
     * 设置值
     * @param  String keys
     * @param  String value
     * @return String
     * */
    public String set(String key, String value);

    /**
     * set key value [nx|xx]
     * 设置值
     * @param  String keys
     * @param  String value
     * @param  String nxxx NX|XX  NX|XX  NX - 只能设置不存在的键    XX - 只能已存在的键
     * @return String
     * */
    public String set(String key, String value, String nxxx);

    /**
     * set key value [ex seconds] [px milliseconds] [nx|xx]
     * 设置值
     * @param  String keys
     * @param  String value
     * @param  String nxxx NX|XX  NX|XX  NX - 只能设置不存在的键    XX - 只能已存在的键
     * @param  String expx EX|PX  EX = 秒; PX = 毫秒
     * @param  int time
     * @return String
     * */
    public String set(String key, String value, String nxxx, String expx, int time);

    /**
     * set key value [ex seconds] [px milliseconds] [nx|xx]
     * 设置值
     * @param  String keys
     * @param  String value
     * @param  String nxxx NX|XX  NX - 只能设置不存在的键    XX - 只能已存在的键
     * @param  String expx EX|PX  EX = 秒; PX = 毫秒
     * @param  int time
     * @return String
     * */
    public String set(String key, String value, String nxxx, String expx, long time);

    /**
     * setex key seconds value
     * 设置值
     * @param  byte[] keys
     * @param  int seconds
     * @param  byte[] value
     * @return String
     * */
    public String setex(byte[] key, int seconds, byte[] value);

    /**
     * setex key seconds value
     * 设置值
     * @param  String keys
     * @param  int seconds
     * @param  String value
     * @return String
     * */
    public String setex(String key, int seconds, String value);

    /**
     * psetex key milliseconds value
     * 设置值
     * @param  byte[] keys
     * @param  long milliseconds
     * @param  byte[] value
     * @return String
     * */
    public String psetex(byte[] key, long milliseconds, byte[] value);

    /**
     * psetex key milliseconds value
     * 设置值
     * @param  String keys
     * @param  long milliseconds
     * @param  String value
     * @return String
     * */
    public String psetex(String key, long milliseconds, String value);

    /**
     * setnx key value
     * 设置值
     * @param  byte[] keys
     * @param  byte[] value
     * @return Long
     * */
    public Long setnx(byte[] key, byte[] value);

    /**
     * setnx key value
     * 设置值
     * @param  String keys
     * @param  String value
     * @return Long
     * */
    public Long setnx(String key, String value);

    /**
     * setbit key offset value
     * 对 key 所储存的字符串值，设置或清除指定偏移量上的位(bit)
     * @param  byte[] keys
     * @param  long offset
     * @param  byte[] value
     * @return Boolean
     * */
    public Boolean setbit(byte[] key, long offset, byte[] value);

    /**
     * setbit key offset value
     * 对 key 所储存的字符串值，设置或清除指定偏移量上的位(bit)
     * @param  byte[] keys
     * @param  long offset
     * @param  boolean value
     * @return Boolean
     * */
    public Boolean setbit(byte[] key, long offset, boolean value);

    /**
     * setbit key offset value
     * 对 key 所储存的字符串值，设置或清除指定偏移量上的位(bit)
     * @param  String keys
     * @param  long offset
     * @param  String value
     * @return Boolean
     * */
    public Boolean setbit(String key, long offset, String value);

    /**
     * setbit key offset value
     * 对 key 所储存的字符串值，设置或清除指定偏移量上的位(bit)
     * @param  String keys
     * @param  long offset
     * @param  boolean value
     * @return Boolean
     * */
    public Boolean setbit(String key, long offset, boolean value);

    /**
     * get key
     * 获取值
     * @param  byte[] keys
     * @return byte[]
     * */
    public byte[] get(byte[] key);

    /**
     * get key
     * 获取值
     * @param  String keys
     * @return String
     * */
    public String get(String key);

    /**
     * mset key value [key value ..]
     * 批量设置值
     * @param  byte[]... keysvalues
     * @return String
     * */
    public String mset(byte[]... keysvalues);

    /**
     * mset key value [key value ..]
     * 批量设置值
     * @param  String... keysvalues
     * @return String
     * */
    public String mset(String... keysvalues);

    /**
     * msetnx key value [key value ..]
     * 批量设置值
     * @param  byte[]... keysvalues
     * @return Long
     * */
    public Long msetnx(byte[]... keysvalues);

    /**
     * msetnx key value [key value ..]
     * 批量设置值
     * @param  String... keysvalues
     * @return Long
     * */
    public Long msetnx(String... keysvalues);

    /**
     * mget key [key ...]
     * 批量获取值
     * @param  byte[]... keys
     * @return List<byte[]>
     * */
    public List<byte[]> mget(byte[]... keys);

    /**
     * mget key [key ...]
     * 批量获取值
     * @param  String... keys
     * @return List<String>
     * */
    public List<String> mget(String... keys);

    /**
     * getbit key offset
     * 对 key 所储存的字符串值，获取指定偏移量上的位(bit)。
     * @param  byte[] key
     * @param  long offset
     * @return Boolean
     * */
    public Boolean getbit(byte[] key, long offset);

    /**
     * getbit key offset
     * 对 key 所储存的字符串值，获取指定偏移量上的位(bit)。
     * @param  String key
     * @param  long offset
     * @return Boolean
     * */
    public Boolean getbit(String key, long offset);

    /**
     * incr key
     * 计数 自增
     * @param  byte[] key
     * @return Long
     * */
    public Long incr(byte[] key);

    /**
     * incr key
     * 计数 自增
     * @param  String key
     * @return Long
     * */
    public Long incr(String key);

    /**
     * decr key
     * 计数 自减
     * @param  byte[] key
     * @return Long
     * */
    public Long decr(byte[] key);

    /**
     * decr key
     * 计数 自减
     * @param  String key
     * @return Long
     * */
    public Long decr(String key);

    /**
     * incrby key increment
     * 计数 自增指定数值
     * @param  byte[] key
     * @param  long increment
     * @return Long
     * */
    public Long incrBy(byte[] key, long increment);

    /**
     * incrby key increment
     * 计数 自增指定数值
     * @param  String key
     * @param  long increment
     * @return Long
     * */
    public Long incrBy(String key, long increment);

    /**
     * decrby key increment
     * 计数 自减指定数值
     * @param  byte[] key
     * @param  long increment
     * @return Long
     * */
    public Long decrBy(byte[] key, long increment);

    /**
     * decrby key increment
     * 计数 自减指定数值
     * @param  String key
     * @param  long increment
     * @return Long
     * */
    public Long decrBy(String key, long increment);

    /**
     * incrbyfloat key increment
     * 计数 自增浮点数
     * @param  byte[] key
     * @param  double increment
     * @return Double
     * */
    public Double incrByFloat(byte[] key, double increment);

    /**
     * incrbyfloat key increment
     * 计数 自增浮点数
     * @param  String key
     * @param  double increment
     * @return Double
     * */
    public Double incrByFloat(String key, double increment);

    /**
     * append key value
     * append可以向字符串尾部追加值
     * @param  byte[] key
     * @param  byte[] value
     * @return Long
     * */
    public Long append(byte[] key, byte[] value);

    /**
     * append key value
     * append可以向字符串尾部追加值
     * @param  String key
     * @param  String value
     * @return Long
     * */
    public Long append(String key, String value);

    /**
     * strlen key
     * 字符串长度
     * 中文占用3个字节
     * @param  byte[] key
     * @return Long
     * */
    public Long strlen(byte[] key);

    /**
     * strlen key
     * 字符串长度
     * 中文占用3个字节
     * @param  String key
     * @return Long
     * */
    public Long strlen(String key);

    /**
     * getset key value
     * 设置并返回原值
     * @param  byte[] key
     * @param  byte[] value
     * @return byte[]
     * */
    public byte[] getSet(byte[] key, byte[] value);

    /**
     * getset key value
     * 设置并返回原值
     * @param  String key
     * @param  String value
     * @return String
     * */
    public String getSet(String key, String value);

    /**
     * setrange key offset value
     * 设置指定位置的字符
     * @param  byte[] key
     * @param  long offset
     * @param  byte[] value
     * @return Long
     * */
    public Long setrange(byte[] key, long offset, byte[] value);

    /**
     * setrange key offset value
     * 设置指定位置的字符
     * @param  String key
     * @param  long offset
     * @param  String value
     * @return Long
     * */
    public Long setrange(String key, long offset, String value);

    /**
     * getrange key start end
     * 获取部分字符串
     * @param  byte[] key
     * @param  long startOffset
     * @param  long endOffset
     * @return byte[]
     * */
    public byte[] getrange(byte[] key, long startOffset, long endOffset);

    /**
     * getrange key start end
     * 获取部分字符串
     * @param  String key
     * @param  long startOffset
     * @param  long endOffset
     * @return String
     * */
    public String getrange(String key, long startOffset, long endOffset);

    /**
     * bitcount key
     * 计算给定字符串中，被设置为 1 的比特位的数量。
     * @param  byte[] key
     * @return Long
     * */
    public Long bitcount(byte[] key);

    /**
     * bitcount key
     * 计算给定字符串中，被设置为 1 的比特位的数量。
     * @param  byte[] key
     * @return Long
     * */
    public Long bitcount(String key);

    /**
     * bitcount key [start] [end]
     * 计算给定字符串中，被设置为 1 的比特位的数量。
     * @param  byte[] key
     * @param  long start
     * @param  long end
     * @return Long
     * */
    public Long bitcount(byte[] key, long start, long end);

    /**
     * bitcount key [start] [end]
     * 计算给定字符串中，被设置为 1 的比特位的数量。
     * @param  String key
     * @param  long start
     * @param  long end
     * @return Long
     * */
    public Long bitcount(String key, long start, long end);

    /**
     * bitop operation destkey key [key ...]
     * 对一个或多个保存二进制位的字符串 key 进行位元操作，并将结果保存到 destkey 上。
     * @param  BitOP op
     * @param  byte[] destKey
     * @param  byte[]... srcKeys
     * @return Long
     * */
    public Long bitop(BitOP op, byte[] destKey, byte[]... srcKeys);

    /**
     * bitop operation destkey key [key ...]
     * 对一个或多个保存二进制位的字符串 key 进行位元操作，并将结果保存到 destkey 上。
     * @param  BitOP op
     * @param  String destKey
     * @param  String... srcKeys
     * @return Long
     * */
    public Long bitop(BitOP op, String destKey, String... srcKeys);

    /**
     * hset key field value
     * 将哈希表 key 中的域 field 的值设为 value 。
     * @param  byte[] key
     * @param  byte[] field
     * @param  byte[] value
     * @return Long
     * */
    public Long hset(byte[] key, byte[] field, byte[] value);

    /**
     * hset key field value
     * 将哈希表 key 中的域 field 的值设为 value 。
     * @param  String key
     * @param  String field
     * @param  String value
     * @return Long
     * */
    public Long hset(String key, String field, String value);

    /**
     * hsetnx key field value
     * 将哈希表 key 中的域 field 的值设为 value 。
     * @param  byte[] key
     * @param  byte[] field
     * @param  byte[] value
     * @return Long
     * */
    public Long hsetnx(byte[] key, byte[] field, byte[] value);

    /**
     * hsetnx key field value
     * 将哈希表 key 中的域 field 的值设为 value 。
     * @param  String key
     * @param  String field
     * @param  String value
     * @return Long
     * */
    public Long hsetnx(String key, String field, String value);

    /**
     * hget key field
     * 返回哈希表 key 中给定域 field 的值。
     * @param  byte[] key
     * @param  byte[] field
     * @return byte[]
     * */
    public byte[] hget(byte[] key, byte[] field);

    /**
     * hget key field
     * 返回哈希表 key 中给定域 field 的值。
     * @param  String key
     * @param  String field
     * @return String
     * */
    public String hget(String key, String field);

    /**
     * hdel key field [field ...]
     * 删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略。
     * @param  byte[] key
     * @param  byte[]... fields
     * @return Long
     * */
    public Long hdel(byte[] key, byte[]... fields);

    /**
     * hdel key field [field ...]
     * 删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略。
     * @param  String key
     * @param  String... fields
     * @return Long
     * */
    public Long hdel(String key, String... fields);

    /**
     * hlen key
     * 返回哈希表 key 中域的数量。
     * @param  byte[] key
     * @return Long
     * */
    public Long hlen(byte[] key);

    /**
     * hlen key
     * 返回哈希表 key 中域的数量。
     * @param  String key
     * @return Long
     * */
    public Long hlen(String key);

    /**
     * hmset key field value [field value ...]
     * 同时将多个 field-value (域-值)对设置到哈希表 key 中。
     * @param  byte[] key
     * @param  Map<byte[], byte[]> hash
     * @return String
     * */
    public String hmset(byte[] key, Map<byte[], byte[]> hash);

    /**
     * hmset key field value [field value ...]
     * 同时将多个 field-value (域-值)对设置到哈希表 key 中。
     * @param  String key
     * @param  Map<String, String> hash
     * @return String
     * */
    public String hmset(String key, Map<String, String> hash);

    /**
     * hmget key field [field ...]
     * 返回哈希表 key 中，一个或多个给定域的值。
     * @param  byte[] key
     * @param  byte[]... fields
     * @return List<byte[]>
     * */
    public List<byte[]> hmget(byte[] key, byte[]... fields);

    /**
     * hmget key field [field ...]
     * 返回哈希表 key 中，一个或多个给定域的值。
     * @param  String key
     * @param  String... fields
     * @return List<String>
     * */
    public List<String> hmget(String key, String... fields);

    /**
     * hexists key field
     * 查看哈希表 key 中，给定域 field 是否存在。
     * @param  byte[] key
     * @param  byte[] field
     * @return Boolean
     * */
    public Boolean hexists(byte[] key, byte[] field);

    /**
     * hexists key field
     * 查看哈希表 key 中，给定域 field 是否存在。
     * @param  String key
     * @param  String field
     * @return Boolean
     * */
    public Boolean hexists(String key, String field);

    /**
     * hkeys key
     * 返回哈希表 key 中的所有域。
     * @param  byte[] key
     * @return Set<byte[]>
     * */
    public Set<byte[]> hkeys(byte[] key);

    /**
     * hkeys key
     * 返回哈希表 key 中的所有域。
     * @param  String key
     * @return Set<String>
     * */
    public Set<String> hkeys(String key);

    /**
     * hvals key
     * 返回哈希表 key 中所有域的值。
     * @param  byte[] key
     * @return List<byte[]>
     * */
    public List<byte[]> hvals(byte[] key);

    /**
     * hvals key
     * 返回哈希表 key 中所有域的值。
     * @param  String key
     * @return List<String>
     * */
    public List<String> hvals(String key);

    /**
     * hgetAll key
     * 返回哈希表 key 中，所有的域和值。
     * @param  byte[] key
     * @return Map<byte[], byte[]>
     * */
    public Map<byte[], byte[]> hgetAll(byte[] key);

    /**
     * hgetAll key
     * 返回哈希表 key 中，所有的域和值。
     * @param  String key
     * @return Map<String, String>
     * */
    public Map<String, String> hgetAll(String key);

    /**
     * hincrby key field increment
     * 为哈希表 key 中的域 field 的值加上增量 increment 。
     * @param  byte[] key
     * @param  byte[] field
     * @param  long value
     * @return Long
     * */
    public Long hincrBy(byte[] key, byte[] field, long value);

    /**
     * hincrby key field increment
     * 为哈希表 key 中的域 field 的值加上增量 increment 。
     * @param  String key
     * @param  String field
     * @param  long value
     * @return Long
     * */
    public Long hincrBy(String key, String field, long value);

    /**
     * hincrbyfloat key field increment
     * 为哈希表 key 中的域 field 加上浮点数增量 increment 。
     * @param  byte[] key
     * @param  byte[] field
     * @param  double value
     * @return Double
     * */
    public Double hincrByFloat(byte[] key, byte[] field, double value);

    /**
     * hincrbyfloat key field increment
     * 为哈希表 key 中的域 field 加上浮点数增量 increment 。
     * @param  String key
     * @param  String field
     * @param  double value
     * @return Double
     * */
    public Double hincrByFloat(String key, String field, double value);

    /**
     * hscan key cursor [match pattern] [count count]
     * 渐进式遍历键
     * @param  byte[] key
     * @param  byte[] cursor
     * @return ScanResult<Map.Entry<byte[], byte[]>>
     * */
    public ScanResult<Map.Entry<byte[], byte[]>> hscan(byte[] key, byte[] cursor);

    /**
     * hscan key cursor [match pattern] [count count]
     * 渐进式遍历键
     * @param  String key
     * @param  int cursor
     * @return ScanResult<Map.Entry<String, String>>
     * */
    @Deprecated
    public ScanResult<Map.Entry<String, String>> hscan(String key, int cursor);

    /**
     * hscan key cursor [match pattern] [count count]
     * 渐进式遍历键
     * @param  String key
     * @param  String cursor
     * @return ScanResult<Map.Entry<String, String>>
     * */
    public ScanResult<Map.Entry<String, String>> hscan(String key, String cursor);

    /**
     * hscan key cursor [match pattern] [count count]
     * 渐进式遍历键
     * @param  byte[] key
     * @param  byte[] cursor
     * @param  ScanParams params
     * @return ScanResult<Map.Entry<byte[], byte[]>>
     * */
    public ScanResult<Map.Entry<byte[], byte[]>> hscan(byte[] key, byte[] cursor, ScanParams params);

    /**
     * hscan key cursor [match pattern] [count count]
     * 渐进式遍历键
     * @param  String key
     * @param  int cursor
     * @param  ScanParams params
     * @return ScanResult<Map.Entry<String, String>>
     * */
    @Deprecated
    public ScanResult<Map.Entry<String, String>> hscan(String key, int cursor, ScanParams params);

    /**
     * hscan key cursor [match pattern] [count count]
     * 渐进式遍历键
     * @param  String key
     * @param  String cursor
     * @param  ScanParams params
     * @return ScanResult<Map.Entry<String, String>>
     * */
    public ScanResult<Map.Entry<String, String>> hscan(String key, String cursor, ScanParams params);

    /**
     * rpush key value [value ...]
     * 将一个或多个值 value 插入到列表 key 的表尾(最右边)。
     * @param  byte[] key
     * @param  byte[]... strings
     * @return Long
     * */
    public Long rpush(byte[] key, byte[]... strings);

    /**
     * rpush key value [value ...]
     * 将一个或多个值 value 插入到列表 key 的表尾(最右边)。
     * @param  String key
     * @param  String... strings
     * @return Long
     * */
    public Long rpush(String key, String... strings);

    /**
     * rpushx key value [value ...]
     * 将值 value 插入到列表 key 的表尾，当且仅当 key 存在并且是一个列表。
     * @param  byte[] key
     * @param  byte[]... strings
     * @return Long
     * */
    public Long rpushx(byte[] key, byte[]... strings);

    /**
     * rpushx key value [value ...]
     * 将值 value 插入到列表 key 的表尾，当且仅当 key 存在并且是一个列表。
     * @param  String key
     * @param  String... strings
     * @return Long
     * */
    public Long rpushx(String key, String... strings);

    /**
     * lpush key value [value ...]
     * 将一个或多个值 value 插入到列表 key 的表头
     * @param  byte[] key
     * @param  byte[]... strings
     * @return Long
     * */
    public Long lpush(byte[] key, byte[]... strings);

    /**
     * lpush key value [value ...]
     * 将一个或多个值 value 插入到列表 key 的表头
     * @param  String key
     * @param  String... strings
     * @return Long
     * */
    public Long lpush(String key, String... strings);

    /**
     * lpushx key value [value ...]
     * 将值 value 插入到列表 key 的表头，当且仅当 key 存在并且是一个列表。
     * @param  byte[] key
     * @param  byte[]... strings
     * @return Long
     * */
    public Long lpushx(byte[] key, byte[]... strings);

    /**
     * lpushx key value [value ...]
     * 将值 value 插入到列表 key 的表头，当且仅当 key 存在并且是一个列表。
     * @param  String key
     * @param  String... strings
     * @return Long
     * */
    public Long lpushx(String key, String... strings);

    /**
     * linsert key before|after pivot value
     * 将值 value 插入到列表 key 当中，位于值 pivot 之前或之后。
     * @param  byte[] key
     * @param  LIST_POSITION where
     * @param  byte[] pivot
     * @param  byte[] value
     * @return Long
     * */
    public Long linsert(byte[] key, LIST_POSITION where, byte[] pivot, byte[] value);

    /**
     * linsert key before|after pivot value
     * 将值 value 插入到列表 key 当中，位于值 pivot 之前或之后。
     * @param  String key
     * @param  LIST_POSITION where
     * @param  String pivot
     * @param  String value
     * @return Long
     * */
    public Long linsert(String key, LIST_POSITION where, String pivot, String value);

    /**
     * lrange key start end
     * 返回列表 key 中指定区间内的元素，区间以偏移量 start 和 end 指定。
     * @param  byte[] key
     * @param  long start
     * @param  long end
     * @return List<byte[]>
     * */
    public List<byte[]> lrange(byte[] key, long start, long end);

    /**
     * lrange key start end
     * 返回列表 key 中指定区间内的元素，区间以偏移量 start 和 end 指定。
     * @param  String key
     * @param  long start
     * @param  long end
     * @return List<String>
     * */
    public List<String> lrange(String key, long start, long end);

    /**
     * lindex key index
     * 返回列表 key 中，下标为 index 的元素。
     * @param  byte[] key
     * @param  long index
     * @return byte[]
     * */
    public byte[] lindex(byte[] key, long index);

    /**
     * lindex key index
     * 返回列表 key 中，下标为 index 的元素。
     * @param  String key
     * @param  long index
     * @return byte[]
     * */
    public String lindex(String key, long index);

    /**
     * llen key
     * 返回列表 key 的长度。
     * @param  byte[] key
     * @return Long
     * */
    public Long llen(byte[] key);

    /**
     * llen key
     * 返回列表 key 的长度。
     * @param  String key
     * @return Long
     * */
    public Long llen(String key);

    /**
     * lpop key
     * 移除并返回列表 key 的头元素。
     * @param  byte[] key
     * @return byte[]
     * */
    public byte[] lpop(byte[] key);

    /**
     * lpop key
     * 移除并返回列表 key 的头元素。
     * @param  String key
     * @return String
     * */
    public String lpop(String key);

    /**
     * rpop key
     * 移除并返回列表 key 的尾元素。
     * @param  byte[] key
     * @return byte[]
     * */
    public byte[] rpop(byte[] key);

    /**
     * rpop key
     * 移除并返回列表 key 的尾元素。
     * @param  String key
     * @return String
     * */
    public String rpop(String key);

    /**
     * lrem key count value
     * 根据参数 count 的值，移除列表中与参数 value 相等的元素。
     * @param  byte[] key
     * @param  long count
     * @param  byte[] value
     * @return Long
     * */
    public Long lrem(byte[] key, long count, byte[] value);

    /**
     * lrem key count value
     * 根据参数 count 的值，移除列表中与参数 value 相等的元素。
     * @param  String key
     * @param  long count
     * @param  String value
     * @return Long
     * */
    public Long lrem(String key, long count, String value);

    /**
     * ltrim key start end
     * 对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除。
     * @param  byte[] key
     * @param  long start
     * @param  long end
     * @return String
     * */
    public String ltrim(byte[] key, long start, long end);

    /**
     * ltrim key start end
     * 对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除。
     * @param  String key
     * @param  long start
     * @param  long end
     * @return String
     * */
    public String ltrim(String key, long start, long end);

    /**
     * lset key index newValue
     * 将列表 key 下标为 index 的元素的值设置为 value 。
     * @param  byte[] key
     * @param  long index
     * @param  byte[] value
     * @return String
     * */
    public String lset(byte[] key, long index, byte[] value);

    /**
     * lset key index newValue
     * 将列表 key 下标为 index 的元素的值设置为 value 。
     * @param  String key
     * @param  long index
     * @param  String value
     * @return String
     * */
    public String lset(String key, long index, String value);

    /**
     * blpop key [key ...] timeout
     * blpop 是列表的阻塞式(blocking)弹出原语。
     * 它是 lpop 命令的阻塞版本，当给定列表内没有任何元素可供弹出的时候，连接将被 blpop 命令阻塞，直到等待超时或发现可弹出元素为止。
     * 当给定多个 key 参数时，按参数 key 的先后顺序依次检查各个列表，弹出第一个非空列表的头元素。
     * @param  byte[] key
     * @return List<byte[]>
     * */
    @Deprecated
    public List<byte[]> blpop(byte[] key);

    /**
     * blpop key [key ...] timeout
     * blpop 是列表的阻塞式(blocking)弹出原语。
     * 它是 lpop 命令的阻塞版本，当给定列表内没有任何元素可供弹出的时候，连接将被 blpop 命令阻塞，直到等待超时或发现可弹出元素为止。
     * 当给定多个 key 参数时，按参数 key 的先后顺序依次检查各个列表，弹出第一个非空列表的头元素。
     * @param  String key
     * @return List<String>
     * */
    @Deprecated
    public List<String> blpop(String key);

    /**
     * blpop key [key ...] timeout
     * blpop 是列表的阻塞式(blocking)弹出原语。
     * 它是 lpop 命令的阻塞版本，当给定列表内没有任何元素可供弹出的时候，连接将被 blpop 命令阻塞，直到等待超时或发现可弹出元素为止。
     * 当给定多个 key 参数时，按参数 key 的先后顺序依次检查各个列表，弹出第一个非空列表的头元素。
     * @param  byte[]... key
     * @return List<byte[]>
     * */
    public List<byte[]> blpop(byte[]... keys);

    /**
     * blpop key [key ...] timeout
     * blpop 是列表的阻塞式(blocking)弹出原语。
     * 它是 lpop 命令的阻塞版本，当给定列表内没有任何元素可供弹出的时候，连接将被 blpop 命令阻塞，直到等待超时或发现可弹出元素为止。
     * 当给定多个 key 参数时，按参数 key 的先后顺序依次检查各个列表，弹出第一个非空列表的头元素。
     * @param  String... key
     * @return List<String>
     * */
    public List<String> blpop(String... key);

    /**
     * blpop key [key ...] timeout
     * blpop 是列表的阻塞式(blocking)弹出原语。
     * 它是 lpop 命令的阻塞版本，当给定列表内没有任何元素可供弹出的时候，连接将被 blpop 命令阻塞，直到等待超时或发现可弹出元素为止。
     * 当给定多个 key 参数时，按参数 key 的先后顺序依次检查各个列表，弹出第一个非空列表的头元素。
     * @param  int timeout
     * @param  byte[]... key
     * @return List<byte[]>
     * */
    public List<byte[]> blpop(int timeout, byte[]... keys);

    /**
     * blpop key [key ...] timeout
     * blpop 是列表的阻塞式(blocking)弹出原语。
     * 它是 lpop 命令的阻塞版本，当给定列表内没有任何元素可供弹出的时候，连接将被 blpop 命令阻塞，直到等待超时或发现可弹出元素为止。
     * 当给定多个 key 参数时，按参数 key 的先后顺序依次检查各个列表，弹出第一个非空列表的头元素。
     * @param  int timeout
     * @param  String... key
     * @return List<String>
     * */
    public List<String> blpop(int timeout, String... keys);

    /**
     * brpop key [key ...] timeout
     * brpop 是列表的阻塞式(blocking)弹出原语。
     * 它是 rpop 命令的阻塞版本，当给定列表内没有任何元素可供弹出的时候，连接将被 brpop 命令阻塞，直到等待超时或发现可弹出元素为止。
     * 当给定多个 key 参数时，按参数 key 的先后顺序依次检查各个列表，弹出第一个非空列表的尾部元素。
     * @param  byte[] key
     * @return List<byte[]>
     * */
    @Deprecated
    public List<byte[]> brpop(byte[] key);

    /**
     * brpop key [key ...] timeout
     * brpop 是列表的阻塞式(blocking)弹出原语。
     * 它是 rpop 命令的阻塞版本，当给定列表内没有任何元素可供弹出的时候，连接将被 brpop 命令阻塞，直到等待超时或发现可弹出元素为止。
     * 当给定多个 key 参数时，按参数 key 的先后顺序依次检查各个列表，弹出第一个非空列表的尾部元素。
     * @param  String key
     * @return List<String>
     * */
    @Deprecated
    public List<String> brpop(String key);

    /**
     * brpop key [key ...] timeout
     * brpop 是列表的阻塞式(blocking)弹出原语。
     * 它是 rpop 命令的阻塞版本，当给定列表内没有任何元素可供弹出的时候，连接将被 brpop 命令阻塞，直到等待超时或发现可弹出元素为止。
     * 当给定多个 key 参数时，按参数 key 的先后顺序依次检查各个列表，弹出第一个非空列表的尾部元素。
     * @param  byte[]... key
     * @return List<byte[]>
     * */
    public List<byte[]> brpop(byte[]... keys);

    /**
     * brpop key [key ...] timeout
     * brpop 是列表的阻塞式(blocking)弹出原语。
     * 它是 rpop 命令的阻塞版本，当给定列表内没有任何元素可供弹出的时候，连接将被 brpop 命令阻塞，直到等待超时或发现可弹出元素为止。
     * 当给定多个 key 参数时，按参数 key 的先后顺序依次检查各个列表，弹出第一个非空列表的尾部元素。
     * @param  String... key
     * @return List<String>
     * */
    public List<String> brpop(String... key);

    /**
     * brpop key [key ...] timeout
     * brpop 是列表的阻塞式(blocking)弹出原语。
     * 它是 rpop 命令的阻塞版本，当给定列表内没有任何元素可供弹出的时候，连接将被 brpop 命令阻塞，直到等待超时或发现可弹出元素为止。
     * 当给定多个 key 参数时，按参数 key 的先后顺序依次检查各个列表，弹出第一个非空列表的尾部元素。
     * @param  int timeout
     * @param  byte[]... key
     * @return List<byte[]>
     * */
    public List<byte[]> brpop(int timeout, byte[]... keys);

    /**
     * brpop key [key ...] timeout
     * brpop 是列表的阻塞式(blocking)弹出原语。
     * 它是 rpop 命令的阻塞版本，当给定列表内没有任何元素可供弹出的时候，连接将被 brpop 命令阻塞，直到等待超时或发现可弹出元素为止。
     * 当给定多个 key 参数时，按参数 key 的先后顺序依次检查各个列表，弹出第一个非空列表的尾部元素。
     * @param  int timeout
     * @param  String... key
     * @return List<String>
     * */
    public List<String> brpop(int timeout, String... keys);

    /**
     * rpoplpush source destination
     * 命令 rpoplpush 在一个原子时间内，执行以下两个动作：
     *        1)将列表 source 中的最后一个元素(尾元素)弹出，并返回给客户端。
     *        2)将 source 弹出的元素插入到列表 destination ，作为 destination 列表的的头元素。
     * @param  byte[] srckey
     * @param  byte[] dstkey
     * @return byte[]
     * */
    public byte[] rpoplpush(byte[] srckey, byte[] dstkey);

    /**
     * rpoplpush source destination
     * 命令 rpoplpush 在一个原子时间内，执行以下两个动作：
     *        1)将列表 source 中的最后一个元素(尾元素)弹出，并返回给客户端。
     *        2)将 source 弹出的元素插入到列表 destination ，作为 destination 列表的的头元素。
     * @param  String srckey
     * @param  String dstkey
     * @return String
     * */
    public String rpoplpush(String srckey, String dstkey);

    /**
     * brpoplpush source destination timeout
     * brpoplpush 是 rpoplpush 的阻塞版本，当给定列表 source 不为空时， brpoplpush 的表现和 rpoplpush 一样。
     * 当列表 source 为空时， brpoplpush 命令将阻塞连接，直到等待超时，或有另一个客户端对 source 执行 LPUSH 或 RPUSH 命令为止。
     * 超时参数 timeout 接受一个以秒为单位的数字作为值。超时参数设为 0 表示阻塞时间可以无限期延长(block indefinitely) 。
     * @param  byte[] source
     * @param  byte[] destination
     * @param  int timeout
     * @return byte[]
     * */
    public byte[] brpoplpush(byte[] source, byte[] destination, int timeout);

    /**
     * brpoplpush source destination timeout
     * brpoplpush 是 rpoplpush 的阻塞版本，当给定列表 source 不为空时， brpoplpush 的表现和 rpoplpush 一样。
     * 当列表 source 为空时， brpoplpush 命令将阻塞连接，直到等待超时，或有另一个客户端对 source 执行 LPUSH 或 RPUSH 命令为止。
     * 超时参数 timeout 接受一个以秒为单位的数字作为值。超时参数设为 0 表示阻塞时间可以无限期延长(block indefinitely) 。
     * @param  String source
     * @param  String destination
     * @param  int timeout
     * @return String
     * */
    public String brpoplpush(String source, String destination, int timeout);

    /**
     * sadd key member [member ...]
     * 将一个或多个 member 元素加入到集合 key 当中，已经存在于集合的 member 元素将被忽略。
     * 假如 key 不存在，则创建一个只包含 member 元素作成员的集合。
     * 当 key 不是集合类型时，返回一个错误。
     * (在Redis2.4版本以前， sadd 只接受单个 member 值。)
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(N)， N 是被添加的元素的数量。
     * 返回值: 被添加到集合中的新元素的数量，不包括被忽略的元素。
     *
     * @param  byte[] key
     * @param  byte[]... members
     * @return Long
     * */
    public Long sadd(byte[] key, byte[]... members);

    /**
     * sadd key member [member ...]
     * 将一个或多个 member 元素加入到集合 key 当中，已经存在于集合的 member 元素将被忽略。
     * 假如 key 不存在，则创建一个只包含 member 元素作成员的集合。
     * 当 key 不是集合类型时，返回一个错误。
     * (在Redis2.4版本以前， sadd 只接受单个 member 值。)
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(N)， N 是被添加的元素的数量。
     * 返回值: 被添加到集合中的新元素的数量，不包括被忽略的元素。
     *
     * @param  String key
     * @param  String... members
     * @return Long
     * */
    public Long sadd(String key, String... members);

    /**
     * scard key
     * 返回集合 key 的基数(集合中元素的数量)。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(1)
     * 返回值: 集合的基数。 当 key 不存在时，返回 0 。
     *
     * @param  byte[] key
     * @return Long
     * */
    public Long scard(byte[] key);

    /**
     * scard key
     * 返回集合 key 的基数(集合中元素的数量)。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(1)
     * 返回值: 集合的基数。 当 key 不存在时，返回 0 。
     *
     * @param  String key
     * @return Long
     * */
    public Long scard(String key);

    /**
     * sdiff key [key ...]
     * 返回一个集合的全部成员，该集合是所有给定集合之间的差集。
     * 不存在的 key 被视为空集。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(N)， N 是所有给定集合的成员数量之和。
     * 返回值: 差集成员的列表。
     *
     * @param  byte[]... keys
     * @return Set<byte[]>
     * */
    public Set<byte[]> sdiff(byte[]... keys);

    /**
     * sdiff key [key ...]
     * 返回一个集合的全部成员，该集合是所有给定集合之间的差集。
     * 不存在的 key 被视为空集。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(N)， N 是所有给定集合的成员数量之和。
     * 返回值: 差集成员的列表。
     *
     * @param  String... keys
     * @return Set<String>
     * */
    public Set<String> sdiff(String... keys);

    /**
     * sdiffstore destination key [key ...]
     * 这个命令的作用和 sdiff 类似，但它将结果保存到 destination 集合，而不是简单地返回结果集。
     * 如果 destination 集合已经存在，则将其覆盖。
     * destination 可以是 key 本身。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(N)， N 是所有给定集合的成员数量之和。
     * 返回值: 结果集中的元素数量。
     *
     * @param  byte[] dstkey
     * @param  byte[]... keys
     * @return Long
     * */
    public Long sdiffstore(byte[] dstkey, byte[]... keys);

    /**
     * sdiffstore destination key [key ...]
     * 这个命令的作用和 sdiff 类似，但它将结果保存到 destination 集合，而不是简单地返回结果集。
     * 如果 destination 集合已经存在，则将其覆盖。
     * destination 可以是 key 本身。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(N)， N 是所有给定集合的成员数量之和。
     * 返回值: 结果集中的元素数量。
     *
     * @param  String dstkey
     * @param  String... keys
     * @return Long
     * */
    public Long sdiffstore(String dstkey, String... keys);

    /**
     * sinter key [key ...]
     * 返回一个集合的全部成员，该集合是所有给定集合的交集。
     * 不存在的 key 被视为空集。
     * 当给定集合当中有一个空集时，结果也为空集(根据集合运算定律)。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(N * M)， N 为给定集合当中基数最小的集合， M 为给定集合的个数。
     * 返回值: 交集成员的列表。
     *
     * @param  byte[]... keys
     * @return Set<byte[]>
     * */
    public Set<byte[]> sinter(byte[]... keys);

    /**
     * sinter key [key ...]
     * 返回一个集合的全部成员，该集合是所有给定集合的交集。
     * 不存在的 key 被视为空集。
     * 当给定集合当中有一个空集时，结果也为空集(根据集合运算定律)。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(N * M)， N 为给定集合当中基数最小的集合， M 为给定集合的个数。
     * 返回值: 交集成员的列表。
     *
     * @param  String... keys
     * @return Set<String>
     * */
    public Set<String> sinter(String... keys);

    /**
     * sinterstore destination key [key ...]
     * 这个命令类似于 sinter 命令，但它将结果保存到 destination 集合，而不是简单地返回结果集。
     * 如果 destination 集合已经存在，则将其覆盖。
     * destination 可以是 key 本身。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(N * M)， N 为给定集合当中基数最小的集合， M 为给定集合的个数。
     * 返回值: 结果集中的成员数量。
     *
     * @param  byte[] dstkey
     * @param  byte[]... keys
     * @return Long
     * */
    public Long sinterstore(byte[] dstkey, byte[]... keys);

    /**
     * sinterstore destination key [key ...]
     * 这个命令类似于 sinter 命令，但它将结果保存到 destination 集合，而不是简单地返回结果集。
     * 如果 destination 集合已经存在，则将其覆盖。
     * destination 可以是 key 本身。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(N * M)， N 为给定集合当中基数最小的集合， M 为给定集合的个数。
     * 返回值: 结果集中的成员数量。
     *
     * @param  String dstkey
     * @param  String... keys
     * @return Long
     * */
    public Long sinterstore(String dstkey, String... keys);

    /**
     * sismember key member
     * 判断 member 元素是否集合 key 的成员。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(1)
     * 返回值: 如果 member 元素是集合的成员，返回 true 。 如果 member 元素不是集合的成员，或 key 不存在，返回  false 。
     *
     * @param  byte[] key
     * @param  byte[] member
     * @return Boolean
     * */
    public Boolean sismember(byte[] key, byte[] member);

    /**
     * sismember key member
     * 判断 member 元素是否集合 key 的成员。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(1)
     * 返回值: 如果 member 元素是集合的成员，返回 true 。 如果 member 元素不是集合的成员，或 key 不存在，返回  false 。
     *
     * @param  String key
     * @param  String member
     * @return Boolean
     * */
    public Boolean sismember(String key, String member);

    /**
     * smembers key
     * 返回集合 key 中的所有成员。
     * 不存在的 key 被视为空集合。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(N)， N 为集合的基数。
     * 返回值: 集合中的所有成员。
     *
     * @param  byte[] key
     * @return Set<byte[]>
     * */
    public Set<byte[]> smembers(byte[] key);

    /**
     * smembers key
     * 返回集合 key 中的所有成员。
     * 不存在的 key 被视为空集合。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(N)， N 为集合的基数。
     * 返回值: 集合中的所有成员。
     *
     * @param  String key
     * @return Set<String>
     * */
    public Set<String> smembers(String key);

    /**
     * smove source destination member
     * 将 member 元素从 source 集合移动到 destination 集合。
     * smove 是原子性操作。
     * 如果 source 集合不存在或不包含指定的 member 元素，则 smove 命令不执行任何操作，仅返回 0 。否则， member 元素从 source 集合中被移除，并添加到 destination 集合中去。
     * 当 destination 集合已经包含 member 元素时， smove 命令只是简单地将 source 集合中的 member 元素删除。
     * 当 source 或 destination 不是集合类型时，返回一个错误。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(1)
     * 返回值: 如果 member 元素被成功移除，返回 1 。如果 member 元素不是 source 集合的成员，并且没有任何操作对 destination 集合执行，那么返回 0 。
     *
     * @param  byte[] srckey
     * @param  byte[] dstkey
     * @param  byte[] member
     * @return Long
     * */
    public Long smove(byte[] srckey, byte[] dstkey, byte[] member);

    /**
     * smove source destination member
     * 将 member 元素从 source 集合移动到 destination 集合。
     * smove 是原子性操作。
     * 如果 source 集合不存在或不包含指定的 member 元素，则 smove 命令不执行任何操作，仅返回 0 。否则， member 元素从 source 集合中被移除，并添加到 destination 集合中去。
     * 当 destination 集合已经包含 member 元素时， smove 命令只是简单地将 source 集合中的 member 元素删除。
     * 当 source 或 destination 不是集合类型时，返回一个错误。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(1)
     * 返回值: 如果 member 元素被成功移除，返回 1 。如果 member 元素不是 source 集合的成员，并且没有任何操作对 destination 集合执行，那么返回 0 。
     *
     * @param  String srckey
     * @param  String dstkey
     * @param  String member
     * @return Long
     * */
    public Long smove(String srckey, String dstkey, String member);

    /**
     * spop key [count]
     * 移除并返回集合中的一个随机元素。
     * 如果只想获取一个随机元素，但不想该元素从集合中被移除的话，可以使用 srandmember 命令。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(1)
     * 返回值: 被移除的随机元素。当 key 不存在或 key 是空集时，返回 nil 。
     *
     * @param  byte[] key
     * @return byte[]
     * */
    public byte[] spop(byte[] key);

    /**
     * spop key [count]
     * 移除并返回集合中的一个随机元素。
     * 如果只想获取一个随机元素，但不想该元素从集合中被移除的话，可以使用 srandmember 命令。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(1)
     * 返回值: 被移除的随机元素。当 key 不存在或 key 是空集时，返回 nil 。
     *
     * @param  String key
     * @return String
     * */
    public String spop(String key);

    /**
     * spop key [count]
     * 移除并返回集合中的多个随机元素。
     * 如果只想获取一个随机元素，但不想该元素从集合中被移除的话，可以使用 srandmember 命令。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(N)
     * 返回值: 被移除的随机元素集合。当 key 不存在或 key 是空集时，返回 nil 。
     *
     * @param  byte[] key
     * @param  long count
     * @return Set<byte[]>
     * */
    public Set<byte[]> spop(byte[] key, long count);

    /**
     * spop key [count]
     * 移除并返回集合中的多个随机元素。
     * 如果只想获取一个随机元素，但不想该元素从集合中被移除的话，可以使用 srandmember 命令。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(N)
     * 返回值: 被移除的随机元素集合。当 key 不存在或 key 是空集时，返回 nil 。
     *
     * @param  String key
     * @param  long count
     * @return Set<String>
     * */
    public Set<String> spop(String key, long count);

    /**
     * srandmember key [count]
     * 如果命令执行时，只提供了 key 参数，那么返回集合中的一个随机元素。
     * 从 Redis 2.6 版本开始， srandmember 命令接受可选的 count 参数：
     *   1.如果 count 为正数，且小于集合基数，那么命令返回一个包含 count 个元素的数组，数组中的元素各不相同。如果 count 大于等于集合基数，那么返回整个集合。
     *   2.如果 count 为负数，那么命令返回一个数组，数组中的元素可能会重复出现多次，而数组的长度为 count 的绝对值。
     *
     * 该操作和 spop 相似，但 SPOP 将随机元素从集合中移除并返回，而 srandmember 则仅仅返回随机元素，而不对集合进行任何改动。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(1)
     * 返回值: 返回随机元素
     *
     * @param  byte[] key
     * @return byte[]
     * */
    public byte[] srandmember(byte[] key);

    /**
     * srandmember key [count]
     * 如果命令执行时，只提供了 key 参数，那么返回集合中的一个随机元素。
     * 从 Redis 2.6 版本开始， srandmember 命令接受可选的 count 参数：
     *   1.如果 count 为正数，且小于集合基数，那么命令返回一个包含 count 个元素的数组，数组中的元素各不相同。如果 count 大于等于集合基数，那么返回整个集合。
     *   2.如果 count 为负数，那么命令返回一个数组，数组中的元素可能会重复出现多次，而数组的长度为 count 的绝对值。
     *
     * 该操作和 spop 相似，但 SPOP 将随机元素从集合中移除并返回，而 srandmember 则仅仅返回随机元素，而不对集合进行任何改动。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(1)
     * 返回值: 返回随机元素
     *
     * @param  String key
     * @return String
     * */
    public String srandmember(String key);

    /**
     * srandmember key [count]
     * 如果命令执行时，只提供了 key 参数，那么返回集合中的一个随机元素。
     * 从 Redis 2.6 版本开始， srandmember 命令接受可选的 count 参数：
     *   1.如果 count 为正数，且小于集合基数，那么命令返回一个包含 count 个元素的数组，数组中的元素各不相同。如果 count 大于等于集合基数，那么返回整个集合。
     *   2.如果 count 为负数，那么命令返回一个数组，数组中的元素可能会重复出现多次，而数组的长度为 count 的绝对值。
     *
     * 该操作和 spop 相似，但 SPOP 将随机元素从集合中移除并返回，而 srandmember 则仅仅返回随机元素，而不对集合进行任何改动。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(N) ，N 为返回数组的元素个数
     * 返回值: 返回随机元素集合
     *
     * @param  byte[] key
     * @param  int count
     * @return List<byte[]>
     * */
    public List<byte[]> srandmember(byte[] key, int count);

    /**
     * srandmember key [count]
     * 如果命令执行时，只提供了 key 参数，那么返回集合中的一个随机元素。
     * 从 Redis 2.6 版本开始， srandmember 命令接受可选的 count 参数：
     *   1.如果 count 为正数，且小于集合基数，那么命令返回一个包含 count 个元素的数组，数组中的元素各不相同。如果 count 大于等于集合基数，那么返回整个集合。
     *   2.如果 count 为负数，那么命令返回一个数组，数组中的元素可能会重复出现多次，而数组的长度为 count 的绝对值。
     *
     * 该操作和 spop 相似，但 SPOP 将随机元素从集合中移除并返回，而 srandmember 则仅仅返回随机元素，而不对集合进行任何改动。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(N) ，N 为返回数组的元素个数
     * 返回值: 返回随机元素集合
     *
     * @param  String key
     * @param  int count
     * @return List<String>
     * */
    public List<String> srandmember(String key, int count);

    /**
     * srem key member [member ...]
     * 当 key 不是集合类型，返回一个错误。
     * (在 Redis 2.4 版本以前， SREM 只接受单个 member 值。)
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(N)， N 为给定 member 元素的数量。
     * 返回值: 被成功移除的元素的数量，不包括被忽略的元素。
     *
     * @param  byte[] key
     * @param  byte[]... members
     * @return Long
     * */
    public Long srem(byte[] key, byte[]... members);

    /**
     * srem key member [member ...]
     * 当 key 不是集合类型，返回一个错误。
     * (在 Redis 2.4 版本以前， SREM 只接受单个 member 值。)
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(N)， N 为给定 member 元素的数量。
     * 返回值: 被成功移除的元素的数量，不包括被忽略的元素。
     *
     * @param  String key
     * @param  String... members
     * @return Long
     * */
    public Long srem(String key, String... members);

    /**
     * sunion key [key ...]
     * 返回一个集合的全部成员，该集合是所有给定集合的并集。
     * 不存在的 key 被视为空集。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(N)， N 是所有给定集合的成员数量之和。
     * 返回值: 并集成员的列表。
     *
     * @param  byte[]... keys
     * @return Set<byte[]>
     * */
    public Set<byte[]> sunion(byte[]... keys);

    /**
     * sunion key [key ...]
     * 返回一个集合的全部成员，该集合是所有给定集合的并集。
     * 不存在的 key 被视为空集。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(N)， N 是所有给定集合的成员数量之和。
     * 返回值: 并集成员的列表。
     *
     * @param  String... keys
     * @return Set<byte[]>
     * */
    public Set<String> sunion(String... keys);

    /**
     * sunionstore destination key [key ...]
     * 这个命令类似于 sunion 命令，但它将结果保存到 destination 集合，而不是简单地返回结果集。
     * 如果 destination 已经存在，则将其覆盖。
     * destination 可以是 key 本身。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(N)， N 是所有给定集合的成员数量之和。
     * 返回值: 结果集中的元素数量。
     *
     * @param  byte[] dstkey
     * @param  byte[]... keys
     * @return Long
     * */
    public Long sunionstore(byte[] dstkey, byte[]... keys);

    /**
     * sunionstore destination key [key ...]
     * 这个命令类似于 sunion 命令，但它将结果保存到 destination 集合，而不是简单地返回结果集。
     * 如果 destination 已经存在，则将其覆盖。
     * destination 可以是 key 本身。
     *
     * 可用版本: >= 1.0.0
     * 时间复杂度: O(N)， N 是所有给定集合的成员数量之和。
     * 返回值: 结果集中的元素数量。
     *
     * @param  String dstkey
     * @param  String... keys
     * @return Long
     * */
    public Long sunionstore(String dstkey, String... keys);

    /**
     * sscan key cursor [match pattern] [count count]
     * 详细信息请参考 SCAN 命令。
     *
     * @param  byte[] key
     * @param  byte[] cursor
     * @return ScanResult<byte[]>
     * */
    public ScanResult<byte[]> sscan(byte[] key, byte[] cursor);

    /**
     * sscan key cursor [match pattern] [count count]
     * 详细信息请参考 SCAN 命令。
     *
     * @param  String key
     * @param  int cursor
     * @return ScanResult<String>
     * */
    @Deprecated
    public ScanResult<String> sscan(String key, int cursor);

    /**
     * sscan key cursor [match pattern] [count count]
     * 详细信息请参考 SCAN 命令。
     *
     * @param  String key
     * @param  String cursor
     * @return ScanResult<String>
     * */
    public ScanResult<String> sscan(String key, String cursor);

    /**
     * sscan key cursor [match pattern] [count count]
     * 详细信息请参考 SCAN 命令。
     *
     * @param  byte[] key
     * @param  byte[] cursor
     * @param  ScanParams params
     * @return ScanResult<byte[]>
     * */
    public ScanResult<byte[]> sscan(byte[] key, byte[] cursor, ScanParams params);

    /**
     * sscan key cursor [match pattern] [count count]
     * 详细信息请参考 SCAN 命令。
     *
     * @param  byte[] key
     * @param  int cursor
     * @param  ScanParams params
     * @return ScanResult<String>
     * */
    @Deprecated
    public ScanResult<String> sscan(String key, int cursor, ScanParams params);

    /**
     * sscan key cursor [match pattern] [count count]
     * 详细信息请参考 SCAN 命令。
     *
     * @param  String key
     * @param  String cursor
     * @param  ScanParams params
     * @return ScanResult<String>
     * */
    public ScanResult<String> sscan(String key, String cursor, ScanParams params);

    /**
     * zadd key score member [[score member] [score member] ...]
     * 将一个或多个 member 元素及其 score 值加入到有序集 key 当中。
     * 如果某个 member 已经是有序集的成员，那么更新这个 member 的 score 值，并通过重新插入这个 member 元素，来保证该 member 在正确的位置上。
     * score 值可以是整数值或双精度浮点数。
     * 如果 key 不存在，则创建一个空的有序集并执行 zadd 操作。
     * 当 key 存在但不是有序集类型时，返回一个错误。
     * 对有序集的更多介绍请参见 sorted set 。
     * (在 Redis 2.4 版本以前， ZADD 每次只能添加一个元素。)
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(M*log(N))， N 是有序集的基数， M 为成功添加的新成员的数量。
     * 返回值: 被成功添加的新成员的数量，不包括那些被更新的、已经存在的成员。
     *
     * @param  byte[] key
     * @param  Map<byte[], Double> scoreMembers
     * @return Long
     * */
    public Long zadd(byte[] key, Map<byte[], Double> scoreMembers);

    /**
     * zadd key score member [[score member] [score member] ...]
     * 将一个或多个 member 元素及其 score 值加入到有序集 key 当中。
     * 如果某个 member 已经是有序集的成员，那么更新这个 member 的 score 值，并通过重新插入这个 member 元素，来保证该 member 在正确的位置上。
     * score 值可以是整数值或双精度浮点数。
     * 如果 key 不存在，则创建一个空的有序集并执行 zadd 操作。
     * 当 key 存在但不是有序集类型时，返回一个错误。
     * 对有序集的更多介绍请参见 sorted set 。
     * (在 Redis 2.4 版本以前， ZADD 每次只能添加一个元素。)
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(M*log(N))， N 是有序集的基数， M 为成功添加的新成员的数量。
     * 返回值: 被成功添加的新成员的数量，不包括那些被更新的、已经存在的成员。
     *
     * @param  String key
     * @param  Map<String, Double> scoreMembers
     * @return Long
     * */
    public Long zadd(String key, Map<String, Double> scoreMembers);

    /**
     * zadd key score member [[score member] [score member] ...]
     * 将一个或多个 member 元素及其 score 值加入到有序集 key 当中。
     * 如果某个 member 已经是有序集的成员，那么更新这个 member 的 score 值，并通过重新插入这个 member 元素，来保证该 member 在正确的位置上。
     * score 值可以是整数值或双精度浮点数。
     * 如果 key 不存在，则创建一个空的有序集并执行 zadd 操作。
     * 当 key 存在但不是有序集类型时，返回一个错误。
     * 对有序集的更多介绍请参见 sorted set 。
     * (在 Redis 2.4 版本以前， ZADD 每次只能添加一个元素。)
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(M*log(N))， N 是有序集的基数， M 为成功添加的新成员的数量。
     * 返回值: 被成功添加的新成员的数量，不包括那些被更新的、已经存在的成员。
     *
     * @param  byte[] key
     * @param  double score
     * @param  byte[] member
     * @return Long
     * */
    public Long zadd(byte[] key, double score, byte[] member);

    /**
     * zadd key score member [[score member] [score member] ...]
     * 将一个或多个 member 元素及其 score 值加入到有序集 key 当中。
     * 如果某个 member 已经是有序集的成员，那么更新这个 member 的 score 值，并通过重新插入这个 member 元素，来保证该 member 在正确的位置上。
     * score 值可以是整数值或双精度浮点数。
     * 如果 key 不存在，则创建一个空的有序集并执行 zadd 操作。
     * 当 key 存在但不是有序集类型时，返回一个错误。
     * 对有序集的更多介绍请参见 sorted set 。
     * (在 Redis 2.4 版本以前， ZADD 每次只能添加一个元素。)
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(M*log(N))， N 是有序集的基数， M 为成功添加的新成员的数量。
     * 返回值: 被成功添加的新成员的数量，不包括那些被更新的、已经存在的成员。
     *
     * @param  String key
     * @param  double score
     * @param  String member
     * @return Long
     * */
    public Long zadd(String key, double score, String member);

    /**
     * zadd key score member [[score member] [score member] ...]
     * 将一个或多个 member 元素及其 score 值加入到有序集 key 当中。
     * 如果某个 member 已经是有序集的成员，那么更新这个 member 的 score 值，并通过重新插入这个 member 元素，来保证该 member 在正确的位置上。
     * score 值可以是整数值或双精度浮点数。
     * 如果 key 不存在，则创建一个空的有序集并执行 zadd 操作。
     * 当 key 存在但不是有序集类型时，返回一个错误。
     * 对有序集的更多介绍请参见 sorted set 。
     * (在 Redis 2.4 版本以前， ZADD 每次只能添加一个元素。)
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(M*log(N))， N 是有序集的基数， M 为成功添加的新成员的数量。
     * 返回值: 被成功添加的新成员的数量，不包括那些被更新的、已经存在的成员。
     *
     * @param  byte[] key
     * @param  Map<byte[], Double> scoreMembers
     * @param  ZAddParams params
     * @return Long
     * */
    public Long zadd(byte[] key, Map<byte[], Double> scoreMembers, ZAddParams params);

    /**
     * zadd key score member [[score member] [score member] ...]
     * 将一个或多个 member 元素及其 score 值加入到有序集 key 当中。
     * 如果某个 member 已经是有序集的成员，那么更新这个 member 的 score 值，并通过重新插入这个 member 元素，来保证该 member 在正确的位置上。
     * score 值可以是整数值或双精度浮点数。
     * 如果 key 不存在，则创建一个空的有序集并执行 zadd 操作。
     * 当 key 存在但不是有序集类型时，返回一个错误。
     * 对有序集的更多介绍请参见 sorted set 。
     * (在 Redis 2.4 版本以前， ZADD 每次只能添加一个元素。)
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(M*log(N))， N 是有序集的基数， M 为成功添加的新成员的数量。
     * 返回值: 被成功添加的新成员的数量，不包括那些被更新的、已经存在的成员。
     *
     * @param  String key
     * @param  Map<String, Double> scoreMembers
     * @param  ZAddParams params
     * @return Long
     * */
    public Long zadd(String key, Map<String, Double> scoreMembers, ZAddParams params);

    /**
     * zadd key score member [[score member] [score member] ...]
     * 将一个或多个 member 元素及其 score 值加入到有序集 key 当中。
     * 如果某个 member 已经是有序集的成员，那么更新这个 member 的 score 值，并通过重新插入这个 member 元素，来保证该 member 在正确的位置上。
     * score 值可以是整数值或双精度浮点数。
     * 如果 key 不存在，则创建一个空的有序集并执行 zadd 操作。
     * 当 key 存在但不是有序集类型时，返回一个错误。
     * 对有序集的更多介绍请参见 sorted set 。
     * (在 Redis 2.4 版本以前， ZADD 每次只能添加一个元素。)
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(M*log(N))， N 是有序集的基数， M 为成功添加的新成员的数量。
     * 返回值: 被成功添加的新成员的数量，不包括那些被更新的、已经存在的成员。
     *
     * @param  byte[] key
     * @param  double score
     * @param  byte[] member
     * @param  ZAddParams params
     * @return Long
     * */
    public Long zadd(byte[] key, double score, byte[] member, ZAddParams params);

    /**
     * zadd key score member [[score member] [score member] ...]
     * 将一个或多个 member 元素及其 score 值加入到有序集 key 当中。
     * 如果某个 member 已经是有序集的成员，那么更新这个 member 的 score 值，并通过重新插入这个 member 元素，来保证该 member 在正确的位置上。
     * score 值可以是整数值或双精度浮点数。
     * 如果 key 不存在，则创建一个空的有序集并执行 zadd 操作。
     * 当 key 存在但不是有序集类型时，返回一个错误。
     * 对有序集的更多介绍请参见 sorted set 。
     * (在 Redis 2.4 版本以前， ZADD 每次只能添加一个元素。)
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(M*log(N))， N 是有序集的基数， M 为成功添加的新成员的数量。
     * 返回值: 被成功添加的新成员的数量，不包括那些被更新的、已经存在的成员。
     *
     * @param  String key
     * @param  double score
     * @param  String member
     * @param  ZAddParams params
     * @return Long
     * */
    public Long zadd(String key, double score, String member, ZAddParams params);

    /**
     * zcard key
     * 返回有序集 key 的基数。
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(1)
     * 返回值: 当 key 存在且是有序集类型时，返回有序集的基数。当 key 不存在时，返回 0 。
     *
     * @param  byte[] key
     * @return Long
     * */
    public Long zcard(byte[] key);

    /**
     * zcard key
     * 返回有序集 key 的基数。
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(1)
     * 返回值: 当 key 存在且是有序集类型时，返回有序集的基数。当 key 不存在时，返回 0 。
     *
     * @param  String key
     * @return Long
     * */
    public Long zcard(String key);

    /**
     * zcount key min max
     * 返回有序集 key 中， score 值在 min 和 max 之间(默认包括 score 值等于 min 或 max )的成员的数量。
     * 关于参数 min 和 max 的详细使用方法，请参考 zrangebyscore 命令。
     *
     * 可用版本: >= 2.0.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为值在 min 和 max 之间的元素的数量
     * 返回值: score 值在 min 和 max 之间的成员的数量
     *
     * @param  byte[] key
     * @param  byte[] min
     * @param  byte[] max
     * @return Long
     * */
    public Long zcount(byte[] key, byte[] min, byte[] max);

    /**
     * zcount key min max
     * 返回有序集 key 中， score 值在 min 和 max 之间(默认包括 score 值等于 min 或 max )的成员的数量。
     * 关于参数 min 和 max 的详细使用方法，请参考 zrangebyscore 命令。
     *
     * 可用版本: >= 2.0.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为值在 min 和 max 之间的元素的数量
     * 返回值: score 值在 min 和 max 之间的成员的数量
     *
     * @param  byte[] key
     * @param  double min
     * @param  double max
     * @return Long
     * */
    public Long zcount(byte[] key, double min, double max);

    /**
     * zcount key min max
     * 返回有序集 key 中， score 值在 min 和 max 之间(默认包括 score 值等于 min 或 max )的成员的数量。
     * 关于参数 min 和 max 的详细使用方法，请参考 zrangebyscore 命令。
     *
     * 可用版本: >= 2.0.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为值在 min 和 max 之间的元素的数量
     * 返回值: score 值在 min 和 max 之间的成员的数量
     *
     * @param  String key
     * @param  double min
     * @param  double max
     * @return Long
     * */
    public Long zcount(String key, double min, double max);

    /**
     * zcount key min max
     * 返回有序集 key 中， score 值在 min 和 max 之间(默认包括 score 值等于 min 或 max )的成员的数量。
     * 关于参数 min 和 max 的详细使用方法，请参考 zrangebyscore 命令。
     *
     * 可用版本: >= 2.0.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为值在 min 和 max 之间的元素的数量
     * 返回值: score 值在 min 和 max 之间的成员的数量
     *
     * @param  String key
     * @param  String min
     * @param  String max
     * @return Long
     * */
    public Long zcount(String key, String min, String max);

    /**
     * zincrby key increment member
     * 为有序集 key 的成员 member 的 score 值加上增量 increment 。
     * 可以通过传递一个负数值 increment ，让 score 减去相应的值，比如 zincrby key -5 member ，就是让 member 的 score 值减去 5 。
     * 当 key 不存在，或 member 不是 key 的成员时， zincrby key increment member 等同于 zadd key increment member 。
     * 当 key 不是有序集类型时，返回一个错误。
     * score 值可以是整数值或双精度浮点数。
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(log(N))
     * 返回值: member 成员的新 score 值，以字符串形式表示。
     *
     * @param  byte[] key
     * @param  double score
     * @param  byte[] member
     * @return Double
     * */
    public Double zincrby(byte[] key, double score, byte[] member);

    /**
     * zincrby key increment member
     * 为有序集 key 的成员 member 的 score 值加上增量 increment 。
     * 可以通过传递一个负数值 increment ，让 score 减去相应的值，比如 zincrby key -5 member ，就是让 member 的 score 值减去 5 。
     * 当 key 不存在，或 member 不是 key 的成员时， zincrby key increment member 等同于 zadd key increment member 。
     * 当 key 不是有序集类型时，返回一个错误。
     * score 值可以是整数值或双精度浮点数。
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(log(N))
     * 返回值: member 成员的新 score 值，以字符串形式表示。
     *
     * @param  String key
     * @param  double score
     * @param  String member
     * @return Double
     * */
    public Double zincrby(String key, double score, String member);

    /**
     * zincrby key increment member
     * 为有序集 key 的成员 member 的 score 值加上增量 increment 。
     * 可以通过传递一个负数值 increment ，让 score 减去相应的值，比如 zincrby key -5 member ，就是让 member 的 score 值减去 5 。
     * 当 key 不存在，或 member 不是 key 的成员时， zincrby key increment member 等同于 zadd key increment member 。
     * 当 key 不是有序集类型时，返回一个错误。
     * score 值可以是整数值或双精度浮点数。
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(log(N))
     * 返回值: member 成员的新 score 值，以字符串形式表示。
     *
     * @param  byte[] key
     * @param  double score
     * @param  byte[] member
     * @param  ZIncrByParams params
     * @return Double
     * */
    public Double zincrby(byte[] key, double score, byte[] member, ZIncrByParams params);

    /**
     * zincrby key increment member
     * 为有序集 key 的成员 member 的 score 值加上增量 increment 。
     * 可以通过传递一个负数值 increment ，让 score 减去相应的值，比如 zincrby key -5 member ，就是让 member 的 score 值减去 5 。
     * 当 key 不存在，或 member 不是 key 的成员时， zincrby key increment member 等同于 zadd key increment member 。
     * 当 key 不是有序集类型时，返回一个错误。
     * score 值可以是整数值或双精度浮点数。
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(log(N))
     * 返回值: member 成员的新 score 值，以字符串形式表示。
     *
     * @param  String key
     * @param  double score
     * @param  String member
     * @param  ZIncrByParams params
     * @return Double
     * */
    public Double zincrby(String key, double score, String member, ZIncrByParams params);

    /**
     * zrange key start stop [withscores]
     * 返回有序集 key 中，指定区间内的成员。
     * 其中成员的位置按 score 值递增(从小到大)来排序。
     * 具有相同 score 值的成员按字典序(lexicographical order )来排列。
     * 如果你需要成员按 score 值递减(从大到小)来排列，请使用 zrevrange 命令。
     * 下标参数 start 和 stop 都以 0 为底，也就是说，以 0 表示有序集第一个成员，以 1 表示有序集第二个成员，以此类推。
     * 你也可以使用负数下标，以 -1 表示最后一个成员， -2 表示倒数第二个成员，以此类推。
     * 超出范围的下标并不会引起错误。
     * 比如说，当 start 的值比有序集的最大下标还要大，或是 start > stop 时， zrange 命令只是简单地返回一个空列表。
     * 另一方面，假如 stop 参数的值比有序集的最大下标还要大，那么 Redis 将 stop 当作最大下标来处理。
     * 可以通过使用 withscores 选项，来让成员和它的 score 值一并返回，返回列表以 value1,score1, ..., valueN,scoreN 的格式表示。
     * 客户端库可能会返回一些更复杂的数据类型，比如数组、元组等。
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数，而 M 为结果集的基数。
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param  byte[] key
     * @param  long start
     * @param  long end
     * @return Set<byte[]>
     * */
    public Set<byte[]> zrange(byte[] key, long start, long end);

    /**
     * zrange key start stop [withscores]
     * 返回有序集 key 中，指定区间内的成员。
     * 其中成员的位置按 score 值递增(从小到大)来排序。
     * 具有相同 score 值的成员按字典序(lexicographical order )来排列。
     * 如果你需要成员按 score 值递减(从大到小)来排列，请使用 zrevrange 命令。
     * 下标参数 start 和 stop 都以 0 为底，也就是说，以 0 表示有序集第一个成员，以 1 表示有序集第二个成员，以此类推。
     * 你也可以使用负数下标，以 -1 表示最后一个成员， -2 表示倒数第二个成员，以此类推。
     * 超出范围的下标并不会引起错误。
     * 比如说，当 start 的值比有序集的最大下标还要大，或是 start > stop 时， zrange 命令只是简单地返回一个空列表。
     * 另一方面，假如 stop 参数的值比有序集的最大下标还要大，那么 Redis 将 stop 当作最大下标来处理。
     * 可以通过使用 withscores 选项，来让成员和它的 score 值一并返回，返回列表以 value1,score1, ..., valueN,scoreN 的格式表示。
     * 客户端库可能会返回一些更复杂的数据类型，比如数组、元组等。
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数，而 M 为结果集的基数。
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param  String key
     * @param  long start
     * @param  long end
     * @return Set<String>
     * */
    public Set<String> zrange(String key, long start, long end);

    /**
     * zrangebyscore key min max [withscores] [limit offset count]
     * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score 值递增(从小到大)次序排列。
     * 具有相同 score 值的成员按字典序(lexicographical order)来排列(该属性是有序集提供的，不需要额外的计算)。
     * 可选的 limit 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
     * 可选的 withscores 参数决定结果集是单单返回有序集的成员，还是将有序集成员及其 score 值一起返回。
     * 该选项自 Redis 2.0 版本起可用。
     * 区间及无限
     * min 和 max 可以是 -inf 和 +inf ，这样一来，你就可以在不知道有序集的最低和最高 score 值的情况下，使用 zrangebyscore 这类命令。
     * 默认情况下，区间的取值使用闭区间 (小于等于或大于等于)，你也可以通过给参数前增加 ( 符号来使用可选的开区间 (小于或大于)。
     * zrangebyscore zset (1 5
     * 返回所有符合条件 1 < score <= 5 的成员，而
     * zrangebyscore zset (5 (10
     * 则返回所有符合条件 5 < score < 10 的成员。
     *
     * 可用版本: >= 1.0.5
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为被结果集的基数
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表
     *
     * @param  byte[] key
     * @param  byte[] min
     * @param  byte[] max
     * @return Set<byte[]>
     * */
    public Set<byte[]> zrangeByScore(byte[] key, byte[] min, byte[] max);

    /**
     * zrangebyscore key min max [withscores] [limit offset count]
     * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score 值递增(从小到大)次序排列。
     * 具有相同 score 值的成员按字典序(lexicographical order)来排列(该属性是有序集提供的，不需要额外的计算)。
     * 可选的 limit 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
     * 可选的 withscores 参数决定结果集是单单返回有序集的成员，还是将有序集成员及其 score 值一起返回。
     * 该选项自 Redis 2.0 版本起可用。
     * 区间及无限
     * min 和 max 可以是 -inf 和 +inf ，这样一来，你就可以在不知道有序集的最低和最高 score 值的情况下，使用 zrangebyscore 这类命令。
     * 默认情况下，区间的取值使用闭区间 (小于等于或大于等于)，你也可以通过给参数前增加 ( 符号来使用可选的开区间 (小于或大于)。
     * zrangebyscore zset (1 5
     * 返回所有符合条件 1 < score <= 5 的成员，而
     * zrangebyscore zset (5 (10
     * 则返回所有符合条件 5 < score < 10 的成员。
     *
     * 可用版本: >= 1.0.5
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为被结果集的基数
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表
     *
     * @param  byte[] key
     * @param  double min
     * @param  double max
     * @return Set<byte[]>
     * */
    public Set<byte[]> zrangeByScore(byte[] key, double min, double max);

    /**
     * zrangebyscore key min max [withscores] [limit offset count]
     * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score 值递增(从小到大)次序排列。
     * 具有相同 score 值的成员按字典序(lexicographical order)来排列(该属性是有序集提供的，不需要额外的计算)。
     * 可选的 limit 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
     * 可选的 withscores 参数决定结果集是单单返回有序集的成员，还是将有序集成员及其 score 值一起返回。
     * 该选项自 Redis 2.0 版本起可用。
     * 区间及无限
     * min 和 max 可以是 -inf 和 +inf ，这样一来，你就可以在不知道有序集的最低和最高 score 值的情况下，使用 zrangebyscore 这类命令。
     * 默认情况下，区间的取值使用闭区间 (小于等于或大于等于)，你也可以通过给参数前增加 ( 符号来使用可选的开区间 (小于或大于)。
     * zrangebyscore zset (1 5
     * 返回所有符合条件 1 < score <= 5 的成员，而
     * zrangebyscore zset (5 (10
     * 则返回所有符合条件 5 < score < 10 的成员。
     *
     * 可用版本: >= 1.0.5
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为被结果集的基数
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表
     *
     * @param  String key
     * @param  double min
     * @param  double max
     * @return Set<String>
     * */
    public Set<String> zrangeByScore(String key, double min, double max);

    /**
     * zrangebyscore key min max [withscores] [limit offset count]
     * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score 值递增(从小到大)次序排列。
     * 具有相同 score 值的成员按字典序(lexicographical order)来排列(该属性是有序集提供的，不需要额外的计算)。
     * 可选的 limit 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
     * 可选的 withscores 参数决定结果集是单单返回有序集的成员，还是将有序集成员及其 score 值一起返回。
     * 该选项自 Redis 2.0 版本起可用。
     * 区间及无限
     * min 和 max 可以是 -inf 和 +inf ，这样一来，你就可以在不知道有序集的最低和最高 score 值的情况下，使用 zrangebyscore 这类命令。
     * 默认情况下，区间的取值使用闭区间 (小于等于或大于等于)，你也可以通过给参数前增加 ( 符号来使用可选的开区间 (小于或大于)。
     * zrangebyscore zset (1 5
     * 返回所有符合条件 1 < score <= 5 的成员，而
     * zrangebyscore zset (5 (10
     * 则返回所有符合条件 5 < score < 10 的成员。
     *
     * 可用版本: >= 1.0.5
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为被结果集的基数
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表
     *
     * @param  String key
     * @param  String min
     * @param  String max
     * @return Set<String>
     * */
    public Set<String> zrangeByScore(String key, String min, String max);

    /**
     * zrangebyscore key min max [withscores] [limit offset count]
     * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score 值递增(从小到大)次序排列。
     * 具有相同 score 值的成员按字典序(lexicographical order)来排列(该属性是有序集提供的，不需要额外的计算)。
     * 可选的 limit 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
     * 可选的 withscores 参数决定结果集是单单返回有序集的成员，还是将有序集成员及其 score 值一起返回。
     * 该选项自 Redis 2.0 版本起可用。
     * 区间及无限
     * min 和 max 可以是 -inf 和 +inf ，这样一来，你就可以在不知道有序集的最低和最高 score 值的情况下，使用 zrangebyscore 这类命令。
     * 默认情况下，区间的取值使用闭区间 (小于等于或大于等于)，你也可以通过给参数前增加 ( 符号来使用可选的开区间 (小于或大于)。
     * zrangebyscore zset (1 5
     * 返回所有符合条件 1 < score <= 5 的成员，而
     * zrangebyscore zset (5 (10
     * 则返回所有符合条件 5 < score < 10 的成员。
     *
     * 可用版本: >= 1.0.5
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为被结果集的基数
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表
     *
     * @param  byte[] key
     * @param  byte[] min
     * @param  byte[] max
     * @return Set<Tuple>
     * */
    public Set<Tuple> zrangeByScoreWithScores(byte[] key, byte[] min, byte[] max);

    /**
     * zrangebyscore key min max [withscores] [limit offset count]
     * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score 值递增(从小到大)次序排列。
     * 具有相同 score 值的成员按字典序(lexicographical order)来排列(该属性是有序集提供的，不需要额外的计算)。
     * 可选的 limit 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
     * 可选的 withscores 参数决定结果集是单单返回有序集的成员，还是将有序集成员及其 score 值一起返回。
     * 该选项自 Redis 2.0 版本起可用。
     * 区间及无限
     * min 和 max 可以是 -inf 和 +inf ，这样一来，你就可以在不知道有序集的最低和最高 score 值的情况下，使用 zrangebyscore 这类命令。
     * 默认情况下，区间的取值使用闭区间 (小于等于或大于等于)，你也可以通过给参数前增加 ( 符号来使用可选的开区间 (小于或大于)。
     * zrangebyscore zset (1 5
     * 返回所有符合条件 1 < score <= 5 的成员，而
     * zrangebyscore zset (5 (10
     * 则返回所有符合条件 5 < score < 10 的成员。
     *
     * 可用版本: >= 1.0.5
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为被结果集的基数
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表
     *
     * @param  byte[] key
     * @param  double min
     * @param  double max
     * @return Set<Tuple>
     * */
    public Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max);

    /**
     * zrangebyscore key min max [withscores] [limit offset count]
     * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score 值递增(从小到大)次序排列。
     * 具有相同 score 值的成员按字典序(lexicographical order)来排列(该属性是有序集提供的，不需要额外的计算)。
     * 可选的 limit 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
     * 可选的 withscores 参数决定结果集是单单返回有序集的成员，还是将有序集成员及其 score 值一起返回。
     * 该选项自 Redis 2.0 版本起可用。
     * 区间及无限
     * min 和 max 可以是 -inf 和 +inf ，这样一来，你就可以在不知道有序集的最低和最高 score 值的情况下，使用 zrangebyscore 这类命令。
     * 默认情况下，区间的取值使用闭区间 (小于等于或大于等于)，你也可以通过给参数前增加 ( 符号来使用可选的开区间 (小于或大于)。
     * zrangebyscore zset (1 5
     * 返回所有符合条件 1 < score <= 5 的成员，而
     * zrangebyscore zset (5 (10
     * 则返回所有符合条件 5 < score < 10 的成员。
     *
     * 可用版本: >= 1.0.5
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为被结果集的基数
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表
     *
     * @param  String key
     * @param  double min
     * @param  double max
     * @return Set<Tuple>
     * */
    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max);

    /**
     * zrangebyscore key min max [withscores] [limit offset count]
     * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score 值递增(从小到大)次序排列。
     * 具有相同 score 值的成员按字典序(lexicographical order)来排列(该属性是有序集提供的，不需要额外的计算)。
     * 可选的 limit 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
     * 可选的 withscores 参数决定结果集是单单返回有序集的成员，还是将有序集成员及其 score 值一起返回。
     * 该选项自 Redis 2.0 版本起可用。
     * 区间及无限
     * min 和 max 可以是 -inf 和 +inf ，这样一来，你就可以在不知道有序集的最低和最高 score 值的情况下，使用 zrangebyscore 这类命令。
     * 默认情况下，区间的取值使用闭区间 (小于等于或大于等于)，你也可以通过给参数前增加 ( 符号来使用可选的开区间 (小于或大于)。
     * zrangebyscore zset (1 5
     * 返回所有符合条件 1 < score <= 5 的成员，而
     * zrangebyscore zset (5 (10
     * 则返回所有符合条件 5 < score < 10 的成员。
     *
     * 可用版本: >= 1.0.5
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为被结果集的基数
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表
     *
     * @param  String key
     * @param  String min
     * @param  String max
     * @return Set<Tuple>
     * */
    public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max);

    /**
     * zrangebyscore key min max [withscores] [limit offset count]
     * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score 值递增(从小到大)次序排列。
     * 具有相同 score 值的成员按字典序(lexicographical order)来排列(该属性是有序集提供的，不需要额外的计算)。
     * 可选的 limit 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
     * 可选的 withscores 参数决定结果集是单单返回有序集的成员，还是将有序集成员及其 score 值一起返回。
     * 该选项自 Redis 2.0 版本起可用。
     * 区间及无限
     * min 和 max 可以是 -inf 和 +inf ，这样一来，你就可以在不知道有序集的最低和最高 score 值的情况下，使用 zrangebyscore 这类命令。
     * 默认情况下，区间的取值使用闭区间 (小于等于或大于等于)，你也可以通过给参数前增加 ( 符号来使用可选的开区间 (小于或大于)。
     * zrangebyscore zset (1 5
     * 返回所有符合条件 1 < score <= 5 的成员，而
     * zrangebyscore zset (5 (10
     * 则返回所有符合条件 5 < score < 10 的成员。
     *
     * 可用版本: >= 1.0.5
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为被结果集的基数
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表
     *
     * @param  byte[] key
     * @param  byte[] min
     * @param  byte[] max
     * @param  int offset
     * @param  int count
     * @return Set<byte[]>
     * */
    public Set<byte[]> zrangeByScore(byte[] key, byte[] min, byte[] max, int offset, int count);

    /**
     * zrangebyscore key min max [withscores] [limit offset count]
     * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score 值递增(从小到大)次序排列。
     * 具有相同 score 值的成员按字典序(lexicographical order)来排列(该属性是有序集提供的，不需要额外的计算)。
     * 可选的 limit 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
     * 可选的 withscores 参数决定结果集是单单返回有序集的成员，还是将有序集成员及其 score 值一起返回。
     * 该选项自 Redis 2.0 版本起可用。
     * 区间及无限
     * min 和 max 可以是 -inf 和 +inf ，这样一来，你就可以在不知道有序集的最低和最高 score 值的情况下，使用 zrangebyscore 这类命令。
     * 默认情况下，区间的取值使用闭区间 (小于等于或大于等于)，你也可以通过给参数前增加 ( 符号来使用可选的开区间 (小于或大于)。
     * zrangebyscore zset (1 5
     * 返回所有符合条件 1 < score <= 5 的成员，而
     * zrangebyscore zset (5 (10
     * 则返回所有符合条件 5 < score < 10 的成员。
     *
     * 可用版本: >= 1.0.5
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为被结果集的基数
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表
     *
     * @param  byte[] key
     * @param  double min
     * @param  double max
     * @param  int offset
     * @param  int count
     * @return Set<byte[]>
     * */
    public Set<byte[]> zrangeByScore(byte[] key, double min, double max, int offset, int count);

    /**
     * zrangebyscore key min max [withscores] [limit offset count]
     * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score 值递增(从小到大)次序排列。
     * 具有相同 score 值的成员按字典序(lexicographical order)来排列(该属性是有序集提供的，不需要额外的计算)。
     * 可选的 limit 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
     * 可选的 withscores 参数决定结果集是单单返回有序集的成员，还是将有序集成员及其 score 值一起返回。
     * 该选项自 Redis 2.0 版本起可用。
     * 区间及无限
     * min 和 max 可以是 -inf 和 +inf ，这样一来，你就可以在不知道有序集的最低和最高 score 值的情况下，使用 zrangebyscore 这类命令。
     * 默认情况下，区间的取值使用闭区间 (小于等于或大于等于)，你也可以通过给参数前增加 ( 符号来使用可选的开区间 (小于或大于)。
     * zrangebyscore zset (1 5
     * 返回所有符合条件 1 < score <= 5 的成员，而
     * zrangebyscore zset (5 (10
     * 则返回所有符合条件 5 < score < 10 的成员。
     *
     * 可用版本: >= 1.0.5
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为被结果集的基数
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表
     *
     * @param  String key
     * @param  double min
     * @param  double max
     * @param  int offset
     * @param  int count
     * @return Set<String>
     * */
    public Set<String> zrangeByScore(String key, double min, double max, int offset, int count);

    /**
     * zrangebyscore key min max [withscores] [limit offset count]
     * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score 值递增(从小到大)次序排列。
     * 具有相同 score 值的成员按字典序(lexicographical order)来排列(该属性是有序集提供的，不需要额外的计算)。
     * 可选的 limit 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
     * 可选的 withscores 参数决定结果集是单单返回有序集的成员，还是将有序集成员及其 score 值一起返回。
     * 该选项自 Redis 2.0 版本起可用。
     * 区间及无限
     * min 和 max 可以是 -inf 和 +inf ，这样一来，你就可以在不知道有序集的最低和最高 score 值的情况下，使用 zrangebyscore 这类命令。
     * 默认情况下，区间的取值使用闭区间 (小于等于或大于等于)，你也可以通过给参数前增加 ( 符号来使用可选的开区间 (小于或大于)。
     * zrangebyscore zset (1 5
     * 返回所有符合条件 1 < score <= 5 的成员，而
     * zrangebyscore zset (5 (10
     * 则返回所有符合条件 5 < score < 10 的成员。
     *
     * 可用版本: >= 1.0.5
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为被结果集的基数
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表
     *
     * @param  String key
     * @param  String min
     * @param  String max
     * @param  int offset
     * @param  int count
     * @return Set<String>
     * */
    public Set<String> zrangeByScore(String key, String min, String max, int offset, int count);

    /**
     * zrangebyscore key min max [withscores] [limit offset count]
     * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score 值递增(从小到大)次序排列。
     * 具有相同 score 值的成员按字典序(lexicographical order)来排列(该属性是有序集提供的，不需要额外的计算)。
     * 可选的 limit 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
     * 可选的 withscores 参数决定结果集是单单返回有序集的成员，还是将有序集成员及其 score 值一起返回。
     * 该选项自 Redis 2.0 版本起可用。
     * 区间及无限
     * min 和 max 可以是 -inf 和 +inf ，这样一来，你就可以在不知道有序集的最低和最高 score 值的情况下，使用 zrangebyscore 这类命令。
     * 默认情况下，区间的取值使用闭区间 (小于等于或大于等于)，你也可以通过给参数前增加 ( 符号来使用可选的开区间 (小于或大于)。
     * zrangebyscore zset (1 5
     * 返回所有符合条件 1 < score <= 5 的成员，而
     * zrangebyscore zset (5 (10
     * 则返回所有符合条件 5 < score < 10 的成员。
     *
     * 可用版本: >= 1.0.5
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为被结果集的基数
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表
     *
     * @param  byte[] key
     * @param  byte[] min
     * @param  byte[] max
     * @param  int offset
     * @param  int count
     * @return Set<Tuple>
     * */
    public Set<Tuple> zrangeByScoreWithScores(byte[] key, byte[] min, byte[] max, int offset, int count);

    /**
     * zrangebyscore key min max [withscores] [limit offset count]
     * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score 值递增(从小到大)次序排列。
     * 具有相同 score 值的成员按字典序(lexicographical order)来排列(该属性是有序集提供的，不需要额外的计算)。
     * 可选的 limit 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
     * 可选的 withscores 参数决定结果集是单单返回有序集的成员，还是将有序集成员及其 score 值一起返回。
     * 该选项自 Redis 2.0 版本起可用。
     * 区间及无限
     * min 和 max 可以是 -inf 和 +inf ，这样一来，你就可以在不知道有序集的最低和最高 score 值的情况下，使用 zrangebyscore 这类命令。
     * 默认情况下，区间的取值使用闭区间 (小于等于或大于等于)，你也可以通过给参数前增加 ( 符号来使用可选的开区间 (小于或大于)。
     * zrangebyscore zset (1 5
     * 返回所有符合条件 1 < score <= 5 的成员，而
     * zrangebyscore zset (5 (10
     * 则返回所有符合条件 5 < score < 10 的成员。
     *
     * 可用版本: >= 1.0.5
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为被结果集的基数
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表
     *
     * @param  byte[] key
     * @param  double min
     * @param  double max
     * @param  int offset
     * @param  int count
     * @return Set<Tuple>
     * */
    public Set<Tuple> zrangeByScoreWithScores(byte[] key, double min, double max, int offset, int count);

    /**
     * zrangebyscore key min max [withscores] [limit offset count]
     * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score 值递增(从小到大)次序排列。
     * 具有相同 score 值的成员按字典序(lexicographical order)来排列(该属性是有序集提供的，不需要额外的计算)。
     * 可选的 limit 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
     * 可选的 withscores 参数决定结果集是单单返回有序集的成员，还是将有序集成员及其 score 值一起返回。
     * 该选项自 Redis 2.0 版本起可用。
     * 区间及无限
     * min 和 max 可以是 -inf 和 +inf ，这样一来，你就可以在不知道有序集的最低和最高 score 值的情况下，使用 zrangebyscore 这类命令。
     * 默认情况下，区间的取值使用闭区间 (小于等于或大于等于)，你也可以通过给参数前增加 ( 符号来使用可选的开区间 (小于或大于)。
     * zrangebyscore zset (1 5
     * 返回所有符合条件 1 < score <= 5 的成员，而
     * zrangebyscore zset (5 (10
     * 则返回所有符合条件 5 < score < 10 的成员。
     *
     * 可用版本: >= 1.0.5
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为被结果集的基数
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表
     *
     * @param  String key
     * @param  double min
     * @param  double max
     * @param  int offset
     * @param  int count
     * @return Set<Tuple>
     * */
    public Set<Tuple> zrangeByScoreWithScores(String key, double min, double max, int offset, int count);

    /**
     * zrangebyscore key min max [withscores] [limit offset count]
     * 返回有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。有序集成员按 score 值递增(从小到大)次序排列。
     * 具有相同 score 值的成员按字典序(lexicographical order)来排列(该属性是有序集提供的，不需要额外的计算)。
     * 可选的 limit 参数指定返回结果的数量及区间(就像SQL中的 SELECT LIMIT offset, count )，注意当 offset 很大时，定位 offset 的操作可能需要遍历整个有序集，此过程最坏复杂度为 O(N) 时间。
     * 可选的 withscores 参数决定结果集是单单返回有序集的成员，还是将有序集成员及其 score 值一起返回。
     * 该选项自 Redis 2.0 版本起可用。
     * 区间及无限
     * min 和 max 可以是 -inf 和 +inf ，这样一来，你就可以在不知道有序集的最低和最高 score 值的情况下，使用 zrangebyscore 这类命令。
     * 默认情况下，区间的取值使用闭区间 (小于等于或大于等于)，你也可以通过给参数前增加 ( 符号来使用可选的开区间 (小于或大于)。
     * zrangebyscore zset (1 5
     * 返回所有符合条件 1 < score <= 5 的成员，而
     * zrangebyscore zset (5 (10
     * 则返回所有符合条件 5 < score < 10 的成员。
     *
     * 可用版本: >= 1.0.5
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为被结果集的基数
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表
     *
     * @param  String key
     * @param  String min
     * @param  String max
     * @param  int offset
     * @param  int count
     * @return Set<Tuple>
     * */
    public Set<Tuple> zrangeByScoreWithScores(String key, String min, String max, int offset, int count);

    /**
     * zrank key member
     * 返回有序集 key 中成员 member 的排名。其中有序集成员按 score 值递增(从小到大)顺序排列。
     * 排名以 0 为底，也就是说， score 值最小的成员排名为 0 。
     * 使用 zrevrank 命令可以获得成员按 score 值递减(从大到小)排列的排名。
     *
     * 可用版本: >= 2.0.0
     * 时间复杂度: O(log(N))
     * 返回值: 如果 member 是有序集 key 的成员，返回 member 的排名。如果 member 不是有序集 key 的成员，返回 nil 。
     *
     * @param  byte[] key
     * @param  byte[] member
     * @return Long
     * */
    public Long zrank(byte[] key, byte[] member);

    /**
     * zrank key member
     * 返回有序集 key 中成员 member 的排名。其中有序集成员按 score 值递增(从小到大)顺序排列。
     * 排名以 0 为底，也就是说， score 值最小的成员排名为 0 。
     * 使用 zrevrank 命令可以获得成员按 score 值递减(从大到小)排列的排名。
     *
     * 可用版本: >= 2.0.0
     * 时间复杂度: O(log(N))
     * 返回值: 如果 member 是有序集 key 的成员，返回 member 的排名。如果 member 不是有序集 key 的成员，返回 nil 。
     *
     * @param  String key
     * @param  String member
     * @return Long
     * */
    public Long zrank(String key, String member);

    /**
     * zrem key member [member ...]
     * 移除有序集 key 中的一个或多个成员，不存在的成员将被忽略。
     * 当 key 存在但不是有序集类型时，返回一个错误。
     * (在 Redis 2.4 版本以前， ZREM 每次只能删除一个元素。)
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(M*log(N))， N 为有序集的基数， M 为被成功移除的成员的数量。
     * 返回值: 被成功移除的成员的数量，不包括被忽略的成员。
     *
     * @param  byte[] key
     * @param  byte[]... members
     * @return Long
     * */
    public Long zrem(byte[] key, byte[]... members);

    /**
     * zrem key member [member ...]
     * 移除有序集 key 中的一个或多个成员，不存在的成员将被忽略。
     * 当 key 存在但不是有序集类型时，返回一个错误。
     * (在 Redis 2.4 版本以前， ZREM 每次只能删除一个元素。)
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(M*log(N))， N 为有序集的基数， M 为被成功移除的成员的数量。
     * 返回值: 被成功移除的成员的数量，不包括被忽略的成员。
     *
     * @param  String key
     * @param  String... members
     * @return Long
     * */
    public Long zrem(String key, String... members);

    /**
     * zremrangebyrank key start stop
     * 移除有序集 key 中，指定排名(rank)区间内的所有成员。
     * 区间分别以下标参数 start 和 stop 指出，包含 start 和 stop 在内。
     * 下标参数 start 和 stop 都以 0 为底，也就是说，以 0 表示有序集第一个成员，以 1 表示有序集第二个成员，以此类推。
     * 你也可以使用负数下标，以 -1 表示最后一个成员， -2 表示倒数第二个成员，以此类推。
     *
     * 可用版本: >= 2.0.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数，而 M 为被移除成员的数量。
     * 返回值: 被移除成员的数量。
     *
     * @param  byte[] key
     * @param  long start
     * @param  long end
     * @return Long
     * */
    public Long zremrangeByRank(byte[] key, long start, long end);

    /**
     * zremrangebyrank key start stop
     * 移除有序集 key 中，指定排名(rank)区间内的所有成员。
     * 区间分别以下标参数 start 和 stop 指出，包含 start 和 stop 在内。
     * 下标参数 start 和 stop 都以 0 为底，也就是说，以 0 表示有序集第一个成员，以 1 表示有序集第二个成员，以此类推。
     * 你也可以使用负数下标，以 -1 表示最后一个成员， -2 表示倒数第二个成员，以此类推。
     *
     * 可用版本: >= 2.0.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数，而 M 为被移除成员的数量。
     * 返回值: 被移除成员的数量。
     *
     * @param  String key
     * @param  long start
     * @param  long end
     * @return Long
     * */
    public Long zremrangeByRank(String key, long start, long end);

    /**
     * zremrangebyscore key min max
     * 移除有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。
     * 自版本2.1.6开始， score 值等于 min 或 max 的成员也可以不包括在内，详情请参见 zrangebyscore 命令。
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数，而 M 为被移除成员的数量。
     * 返回值: 被移除成员的数量。
     *
     * @param  byte[] key
     * @param  byte[] start
     * @param  byte[] end
     * @return Long
     * */
    public Long zremrangeByScore(byte[] key, byte[] start, byte[] end);

    /**
     * zremrangebyscore key min max
     * 移除有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。
     * 自版本2.1.6开始， score 值等于 min 或 max 的成员也可以不包括在内，详情请参见 zrangebyscore 命令。
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数，而 M 为被移除成员的数量。
     * 返回值: 被移除成员的数量。
     *
     * @param  byte[] key
     * @param  double start
     * @param  double end
     * @return Long
     * */
    public Long zremrangeByScore(byte[] key, double start, double end);

    /**
     * zremrangebyscore key min max
     * 移除有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。
     * 自版本2.1.6开始， score 值等于 min 或 max 的成员也可以不包括在内，详情请参见 zrangebyscore 命令。
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数，而 M 为被移除成员的数量。
     * 返回值: 被移除成员的数量。
     *
     * @param  String key
     * @param  double start
     * @param  double end
     * @return Long
     * */
    public Long zremrangeByScore(String key, double start, double end);

    /**
     * zremrangebyscore key min max
     * 移除有序集 key 中，所有 score 值介于 min 和 max 之间(包括等于 min 或 max )的成员。
     * 自版本2.1.6开始， score 值等于 min 或 max 的成员也可以不包括在内，详情请参见 zrangebyscore 命令。
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数，而 M 为被移除成员的数量。
     * 返回值: 被移除成员的数量。
     *
     * @param  String key
     * @param  String start
     * @param  String end
     * @return Long
     * */
    public Long zremrangeByScore(String key, String start, String end);

    /**
     * zrevrange key start stop [withscores]
     * 返回有序集 key 中，指定区间内的成员。
     * 其中成员的位置按 score 值递减(从大到小)来排列。
     * 具有相同 score 值的成员按字典序的逆序(reverse lexicographical order)排列。
     * 除了成员按 score 值递减的次序排列这一点外， zrevrange 命令的其他方面和 zrange 命令一样。
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数，而 M 为结果集的基数。
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param  byte[] key
     * @param  long start
     * @param  long end
     * @return Set<byte[]>
     * */
    public Set<byte[]> zrevrange(byte[] key, long start, long end);

    /**
     * zrevrange key start stop [withscores]
     * 返回有序集 key 中，指定区间内的成员。
     * 其中成员的位置按 score 值递减(从大到小)来排列。
     * 具有相同 score 值的成员按字典序的逆序(reverse lexicographical order)排列。
     * 除了成员按 score 值递减的次序排列这一点外， zrevrange 命令的其他方面和 zrange 命令一样。
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数，而 M 为结果集的基数。
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param  String key
     * @param  long start
     * @param  long end
     * @return Set<String>
     * */
    public Set<String> zrevrange(String key, long start, long end);

    /**
     * zrevrangebyscore key max min [withscores] [limit offset count]
     * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score 值递减(从大到小)的次序排列。
     * 具有相同 score 值的成员按字典序的逆序(reverse lexicographical order )排列。
     * 除了成员按 score 值递减的次序排列这一点外， zrevrangebyscore 命令的其他方面和 zrangebyscore 命令一样。
     *
     * 可用版本: >= 2.2.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为结果集的基数。
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param  byte[] key
     * @param  byte[] max
     * @param  byte[] min
     * @return Set<byte[]>
     * */
    public Set<byte[]> zrevrangeByScore(byte[] key, byte[] max, byte[] min);

    /**
     * zrevrangebyscore key max min [withscores] [limit offset count]
     * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score 值递减(从大到小)的次序排列。
     * 具有相同 score 值的成员按字典序的逆序(reverse lexicographical order )排列。
     * 除了成员按 score 值递减的次序排列这一点外， zrevrangebyscore 命令的其他方面和 zrangebyscore 命令一样。
     *
     * 可用版本: >= 2.2.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为结果集的基数。
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param  byte[] key
     * @param  double max
     * @param  double min
     * @return Set<byte[]>
     * */
    public Set<byte[]> zrevrangeByScore(byte[] key, double max, double min);

    /**
     * zrevrangebyscore key max min [withscores] [limit offset count]
     * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score 值递减(从大到小)的次序排列。
     * 具有相同 score 值的成员按字典序的逆序(reverse lexicographical order )排列。
     * 除了成员按 score 值递减的次序排列这一点外， zrevrangebyscore 命令的其他方面和 zrangebyscore 命令一样。
     *
     * 可用版本: >= 2.2.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为结果集的基数。
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param  String key
     * @param  double max
     * @param  double min
     * @return Set<String>
     * */
    public Set<String> zrevrangeByScore(String key, double max, double min);

    /**
     * zrevrangebyscore key max min [withscores] [limit offset count]
     * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score 值递减(从大到小)的次序排列。
     * 具有相同 score 值的成员按字典序的逆序(reverse lexicographical order )排列。
     * 除了成员按 score 值递减的次序排列这一点外， zrevrangebyscore 命令的其他方面和 zrangebyscore 命令一样。
     *
     * 可用版本: >= 2.2.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为结果集的基数。
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param  String key
     * @param  double max
     * @param  double min
     * @return Set<String>
     * */
    public Set<String> zrevrangeByScore(String key, String max, String min);

    /**
     * zrevrangebyscore key max min [withscores] [limit offset count]
     * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score 值递减(从大到小)的次序排列。
     * 具有相同 score 值的成员按字典序的逆序(reverse lexicographical order )排列。
     * 除了成员按 score 值递减的次序排列这一点外， zrevrangebyscore 命令的其他方面和 zrangebyscore 命令一样。
     *
     * 可用版本: >= 2.2.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为结果集的基数。
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param  byte[] key
     * @param  byte[] max
     * @param  byte[] min
     * @return Set<Tuple>
     * */
    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, byte[] max, byte[] min);

    /**
     * zrevrangebyscore key max min [withscores] [limit offset count]
     * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score 值递减(从大到小)的次序排列。
     * 具有相同 score 值的成员按字典序的逆序(reverse lexicographical order )排列。
     * 除了成员按 score 值递减的次序排列这一点外， zrevrangebyscore 命令的其他方面和 zrangebyscore 命令一样。
     *
     * 可用版本: >= 2.2.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为结果集的基数。
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param  byte[] key
     * @param  double max
     * @param  double min
     * @return Set<Tuple>
     * */
    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max, double min);

    /**
     * zrevrangebyscore key max min [withscores] [limit offset count]
     * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score 值递减(从大到小)的次序排列。
     * 具有相同 score 值的成员按字典序的逆序(reverse lexicographical order )排列。
     * 除了成员按 score 值递减的次序排列这一点外， zrevrangebyscore 命令的其他方面和 zrangebyscore 命令一样。
     *
     * 可用版本: >= 2.2.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为结果集的基数。
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param  String key
     * @param  double max
     * @param  double min
     * @return Set<Tuple>
     * */
    public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min);

    /**
     * zrevrangebyscore key max min [withscores] [limit offset count]
     * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score 值递减(从大到小)的次序排列。
     * 具有相同 score 值的成员按字典序的逆序(reverse lexicographical order )排列。
     * 除了成员按 score 值递减的次序排列这一点外， zrevrangebyscore 命令的其他方面和 zrangebyscore 命令一样。
     *
     * 可用版本: >= 2.2.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为结果集的基数。
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param  String key
     * @param  double max
     * @param  double min
     * @return Set<Tuple>
     * */
    public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min);

    /**
     * zrevrangebyscore key max min [withscores] [limit offset count]
     * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score 值递减(从大到小)的次序排列。
     * 具有相同 score 值的成员按字典序的逆序(reverse lexicographical order )排列。
     * 除了成员按 score 值递减的次序排列这一点外， zrevrangebyscore 命令的其他方面和 zrangebyscore 命令一样。
     *
     * 可用版本: >= 2.2.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为结果集的基数。
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param  byte[] key
     * @param  byte[] max
     * @param  byte[] min
     * @param  int offset
     * @param  int count
     * @return Set<byte[]>
     * */
    public Set<byte[]> zrevrangeByScore(byte[] key, byte[] max, byte[] min, int offset, int count);

    /**
     * zrevrangebyscore key max min [withscores] [limit offset count]
     * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score 值递减(从大到小)的次序排列。
     * 具有相同 score 值的成员按字典序的逆序(reverse lexicographical order )排列。
     * 除了成员按 score 值递减的次序排列这一点外， zrevrangebyscore 命令的其他方面和 zrangebyscore 命令一样。
     *
     * 可用版本: >= 2.2.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为结果集的基数。
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param  byte[] key
     * @param  double max
     * @param  double min
     * @param  int offset
     * @param  int count
     * @return Set<byte[]>
     * */
    public Set<byte[]> zrevrangeByScore(byte[] key, double max, double min, int offset, int count);

    /**
     * zrevrangebyscore key max min [withscores] [limit offset count]
     * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score 值递减(从大到小)的次序排列。
     * 具有相同 score 值的成员按字典序的逆序(reverse lexicographical order )排列。
     * 除了成员按 score 值递减的次序排列这一点外， zrevrangebyscore 命令的其他方面和 zrangebyscore 命令一样。
     *
     * 可用版本: >= 2.2.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为结果集的基数。
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param  String key
     * @param  double max
     * @param  double min
     * @param  int offset
     * @param  int count
     * @return Set<String>
     * */
    public Set<String> zrevrangeByScore(String key, double max, double min, int offset, int count);

    /**
     * zrevrangebyscore key max min [withscores] [limit offset count]
     * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score 值递减(从大到小)的次序排列。
     * 具有相同 score 值的成员按字典序的逆序(reverse lexicographical order )排列。
     * 除了成员按 score 值递减的次序排列这一点外， zrevrangebyscore 命令的其他方面和 zrangebyscore 命令一样。
     *
     * 可用版本: >= 2.2.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为结果集的基数。
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param  String key
     * @param  String max
     * @param  String min
     * @param  int offset
     * @param  int count
     * @return Set<String>
     * */
    public Set<String> zrevrangeByScore(String key, String max, String min, int offset, int count);

    /**
     * zrevrangebyscore key max min [withscores] [limit offset count]
     * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score 值递减(从大到小)的次序排列。
     * 具有相同 score 值的成员按字典序的逆序(reverse lexicographical order )排列。
     * 除了成员按 score 值递减的次序排列这一点外， zrevrangebyscore 命令的其他方面和 zrangebyscore 命令一样。
     *
     * 可用版本: >= 2.2.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为结果集的基数。
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param  byte[] key
     * @param  byte[] max
     * @param  byte[] min
     * @param  int offset
     * @param  int count
     * @return Set<Tuple>
     * */
    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, byte[] max, byte[] min, int offset, int count);

    /**
     * zrevrangebyscore key max min [withscores] [limit offset count]
     * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score 值递减(从大到小)的次序排列。
     * 具有相同 score 值的成员按字典序的逆序(reverse lexicographical order )排列。
     * 除了成员按 score 值递减的次序排列这一点外， zrevrangebyscore 命令的其他方面和 zrangebyscore 命令一样。
     *
     * 可用版本: >= 2.2.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为结果集的基数。
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param  byte[] key
     * @param  double max
     * @param  double min
     * @param  int offset
     * @param  int count
     * @return Set<Tuple>
     * */
    public Set<Tuple> zrevrangeByScoreWithScores(byte[] key, double max, double min, int offset, int count);

    /**
     * zrevrangebyscore key max min [withscores] [limit offset count]
     * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score 值递减(从大到小)的次序排列。
     * 具有相同 score 值的成员按字典序的逆序(reverse lexicographical order )排列。
     * 除了成员按 score 值递减的次序排列这一点外， zrevrangebyscore 命令的其他方面和 zrangebyscore 命令一样。
     *
     * 可用版本: >= 2.2.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为结果集的基数。
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param  String key
     * @param  double max
     * @param  double min
     * @param  int offset
     * @param  int count
     * @return Set<Tuple>
     * */
    public Set<Tuple> zrevrangeByScoreWithScores(String key, double max, double min, int offset, int count);

    /**
     * zrevrangebyscore key max min [withscores] [limit offset count]
     * 返回有序集 key 中， score 值介于 max 和 min 之间(默认包括等于 max 或 min )的所有的成员。有序集成员按 score 值递减(从大到小)的次序排列。
     * 具有相同 score 值的成员按字典序的逆序(reverse lexicographical order )排列。
     * 除了成员按 score 值递减的次序排列这一点外， zrevrangebyscore 命令的其他方面和 zrangebyscore 命令一样。
     *
     * 可用版本: >= 2.2.0
     * 时间复杂度: O(log(N)+M)， N 为有序集的基数， M 为结果集的基数。
     * 返回值: 指定区间内，带有 score 值(可选)的有序集成员的列表。
     *
     * @param  String key
     * @param  String max
     * @param  String min
     * @param  int offset
     * @param  int count
     * @return Set<Tuple>
     * */
    public Set<Tuple> zrevrangeByScoreWithScores(String key, String max, String min, int offset, int count);

    /**
     * zrevrank key member
     * 返回有序集 key 中成员 member 的排名。其中有序集成员按 score 值递减(从大到小)排序。
     * 排名以 0 为底，也就是说， score 值最大的成员排名为 0 。
     * 使用 ZRANK 命令可以获得成员按 score 值递增(从小到大)排列的排名。
     *
     * 可用版本: >= 2.0.0
     * 时间复杂度: O(log(N))
     * 返回值: 如果 member 是有序集 key 的成员，返回 member 的排名。如果 member 不是有序集 key 的成员，返回 nil 。
     *
     * @param  byte[] key
     * @param  byte[] member
     * @return Long
     * */
    public Long zrevrank(byte[] key, byte[] member);

    /**
     * zrevrank key member
     * 返回有序集 key 中成员 member 的排名。其中有序集成员按 score 值递减(从大到小)排序。
     * 排名以 0 为底，也就是说， score 值最大的成员排名为 0 。
     * 使用 ZRANK 命令可以获得成员按 score 值递增(从小到大)排列的排名。
     *
     * 可用版本: >= 2.0.0
     * 时间复杂度: O(log(N))
     * 返回值: 如果 member 是有序集 key 的成员，返回 member 的排名。如果 member 不是有序集 key 的成员，返回 nil 。
     *
     * @param  String key
     * @param  String member
     * @return Long
     * */
    public Long zrevrank(String key, String member);

    /**
     * zscore key member
     * 返回有序集 key 中，成员 member 的 score 值。
     * 如果 member 元素不是有序集 key 的成员，或 key 不存在，返回 nil 。
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(1)
     * 返回值: member 成员的 score 值，以字符串形式表示。
     *
     * @param  byte[] key
     * @param  byte[] member
     * @return Double
     * */
    public Double zscore(byte[] key, byte[] member);

    /**
     * zscore key member
     * 返回有序集 key 中，成员 member 的 score 值。
     * 如果 member 元素不是有序集 key 的成员，或 key 不存在，返回 nil 。
     *
     * 可用版本: >= 1.2.0
     * 时间复杂度: O(1)
     * 返回值: member 成员的 score 值，以字符串形式表示。
     *
     * @param  String key
     * @param  String member
     * @return Double
     * */
    public Double zscore(String key, String member);

    /**
     * zunionstore destination numkeys key [key ...] [weights weight [weight ...]] [aggregate sum|min|max]
     * 计算给定的一个或多个有序集的并集，其中给定 key 的数量必须以 numkeys 参数指定，并将该并集(结果集)储存到 destination 。
     * 默认情况下，结果集中某个成员的 score 值是所有给定集下该成员 score 值之 和 。
     * weights
     *   使用 weights 选项，你可以为 每个 给定有序集 分别 指定一个乘法因子(multiplication factor)，每个给定有序集的所有成员的 score 值在传递给聚合函数(aggregation function)之前都要先乘以该有序集的因子。
     *   如果没有指定 weights 选项，乘法因子默认设置为 1 。
     * aggregate
     *   使用 aggregate 选项，你可以指定并集的结果集的聚合方式。
     *   默认使用的参数 sum ，可以将所有集合中某个成员的 score 值之 和 作为结果集中该成员的 score 值；
     *   使用参数 min ，可以将所有集合中某个成员的 最小 score 值作为结果集中该成员的 score 值；
     *   而参数 max 则是将所有集合中某个成员的 最大 score 值作为结果集中该成员的 score 值。
     *
     * 可用版本: >= 2.0.0
     * 时间复杂度: O(N)+O(M log(M))， N 为给定有序集基数的总和， M 为结果集的基数。
     * 返回值: 保存到 destination 的结果集的基数。
     *
     * @param  byte[] dstkey
     * @param  byte[]... sets
     * @return Long
     * */
    public Long zunionstore(byte[] dstkey, byte[]... sets);

    /**
     * zunionstore destination numkeys key [key ...] [weights weight [weight ...]] [aggregate sum|min|max]
     * 计算给定的一个或多个有序集的并集，其中给定 key 的数量必须以 numkeys 参数指定，并将该并集(结果集)储存到 destination 。
     * 默认情况下，结果集中某个成员的 score 值是所有给定集下该成员 score 值之 和 。
     * weights
     *   使用 weights 选项，你可以为 每个 给定有序集 分别 指定一个乘法因子(multiplication factor)，每个给定有序集的所有成员的 score 值在传递给聚合函数(aggregation function)之前都要先乘以该有序集的因子。
     *   如果没有指定 weights 选项，乘法因子默认设置为 1 。
     * aggregate
     *   使用 aggregate 选项，你可以指定并集的结果集的聚合方式。
     *   默认使用的参数 sum ，可以将所有集合中某个成员的 score 值之 和 作为结果集中该成员的 score 值；
     *   使用参数 min ，可以将所有集合中某个成员的 最小 score 值作为结果集中该成员的 score 值；
     *   而参数 max 则是将所有集合中某个成员的 最大 score 值作为结果集中该成员的 score 值。
     *
     * 可用版本: >= 2.0.0
     * 时间复杂度: O(N)+O(M log(M))， N 为给定有序集基数的总和， M 为结果集的基数。
     * 返回值: 保存到 destination 的结果集的基数。
     *
     * @param  String dstkey
     * @param  String... sets
     * @return Long
     * */
    public Long zunionstore(String dstkey, String... sets);

    /**
     * zunionstore destination numkeys key [key ...] [weights weight [weight ...]] [aggregate sum|min|max]
     * 计算给定的一个或多个有序集的并集，其中给定 key 的数量必须以 numkeys 参数指定，并将该并集(结果集)储存到 destination 。
     * 默认情况下，结果集中某个成员的 score 值是所有给定集下该成员 score 值之 和 。
     * weights
     *   使用 weights 选项，你可以为 每个 给定有序集 分别 指定一个乘法因子(multiplication factor)，每个给定有序集的所有成员的 score 值在传递给聚合函数(aggregation function)之前都要先乘以该有序集的因子。
     *   如果没有指定 weights 选项，乘法因子默认设置为 1 。
     * aggregate
     *   使用 aggregate 选项，你可以指定并集的结果集的聚合方式。
     *   默认使用的参数 sum ，可以将所有集合中某个成员的 score 值之 和 作为结果集中该成员的 score 值；
     *   使用参数 min ，可以将所有集合中某个成员的 最小 score 值作为结果集中该成员的 score 值；
     *   而参数 max 则是将所有集合中某个成员的 最大 score 值作为结果集中该成员的 score 值。
     *
     * 可用版本: >= 2.0.0
     * 时间复杂度: O(N)+O(M log(M))， N 为给定有序集基数的总和， M 为结果集的基数。
     * 返回值: 保存到 destination 的结果集的基数。
     *
     * @param  byte[] dstkey
     * @param  ZParams params
     * @param  byte[]... sets
     * @return Long
     * */
    public Long zunionstore(byte[] dstkey, ZParams params, byte[]... sets);

    /**
     * zunionstore destination numkeys key [key ...] [weights weight [weight ...]] [aggregate sum|min|max]
     * 计算给定的一个或多个有序集的并集，其中给定 key 的数量必须以 numkeys 参数指定，并将该并集(结果集)储存到 destination 。
     * 默认情况下，结果集中某个成员的 score 值是所有给定集下该成员 score 值之 和 。
     * weights
     *   使用 weights 选项，你可以为 每个 给定有序集 分别 指定一个乘法因子(multiplication factor)，每个给定有序集的所有成员的 score 值在传递给聚合函数(aggregation function)之前都要先乘以该有序集的因子。
     *   如果没有指定 weights 选项，乘法因子默认设置为 1 。
     * aggregate
     *   使用 aggregate 选项，你可以指定并集的结果集的聚合方式。
     *   默认使用的参数 sum ，可以将所有集合中某个成员的 score 值之 和 作为结果集中该成员的 score 值；
     *   使用参数 min ，可以将所有集合中某个成员的 最小 score 值作为结果集中该成员的 score 值；
     *   而参数 max 则是将所有集合中某个成员的 最大 score 值作为结果集中该成员的 score 值。
     *
     * 可用版本: >= 2.0.0
     * 时间复杂度: O(N)+O(M log(M))， N 为给定有序集基数的总和， M 为结果集的基数。
     * 返回值: 保存到 destination 的结果集的基数。
     *
     * @param  String dstkey
     * @param  ZParams params
     * @param  String... sets
     * @return Long
     * */
    public Long zunionstore(String dstkey, ZParams params, String... sets);

    /**
     * zinterstore destination numkeys key [key ...] [weights weight [weight ...]] [aggregate sum|min|max]
     * 计算给定的一个或多个有序集的交集，其中给定 key 的数量必须以 numkeys 参数指定，并将该交集(结果集)储存到 destination 。
     * 默认情况下，结果集中某个成员的 score 值是所有给定集下该成员 score 值之和.
     * 关于 weights 和 aggregate 选项的描述，参见 zunionstore 命令。
     *
     * 可用版本: >= 2.0.0
     * 时间复杂度: O(N*K)+O(M*log(M))， N 为给定 key 中基数最小的有序集， K 为给定有序集的数量， M 为结果集的基数。
     * 返回值: 保存到 destination 的结果集的基数。
     *
     * @param  byte[] dstkey
     * @param  byte[]... sets
     * @return Long
     * */
    public Long zinterstore(byte[] dstkey, byte[]... sets);

    /**
     * zinterstore destination numkeys key [key ...] [weights weight [weight ...]] [aggregate sum|min|max]
     * 计算给定的一个或多个有序集的交集，其中给定 key 的数量必须以 numkeys 参数指定，并将该交集(结果集)储存到 destination 。
     * 默认情况下，结果集中某个成员的 score 值是所有给定集下该成员 score 值之和.
     * 关于 weights 和 aggregate 选项的描述，参见 zunionstore 命令。
     *
     * 可用版本: >= 2.0.0
     * 时间复杂度: O(N*K)+O(M*log(M))， N 为给定 key 中基数最小的有序集， K 为给定有序集的数量， M 为结果集的基数。
     * 返回值: 保存到 destination 的结果集的基数。
     *
     * @param  String dstkey
     * @param  String... sets
     * @return Long
     * */
    public Long zinterstore(String dstkey, String... sets);

    /**
     * zinterstore destination numkeys key [key ...] [weights weight [weight ...]] [aggregate sum|min|max]
     * 计算给定的一个或多个有序集的交集，其中给定 key 的数量必须以 numkeys 参数指定，并将该交集(结果集)储存到 destination 。
     * 默认情况下，结果集中某个成员的 score 值是所有给定集下该成员 score 值之和.
     * 关于 weights 和 aggregate 选项的描述，参见 zunionstore 命令。
     *
     * 可用版本: >= 2.0.0
     * 时间复杂度: O(N*K)+O(M*log(M))， N 为给定 key 中基数最小的有序集， K 为给定有序集的数量， M 为结果集的基数。
     * 返回值: 保存到 destination 的结果集的基数。
     *
     * @param  byte[] dstkey
     * @param  ZParams params
     * @param  byte[]... sets
     * @return Long
     * */
    public Long zinterstore(byte[] dstkey, ZParams params, byte[]... sets);

    /**
     * zinterstore destination numkeys key [key ...] [weights weight [weight ...]] [aggregate sum|min|max]
     * 计算给定的一个或多个有序集的交集，其中给定 key 的数量必须以 numkeys 参数指定，并将该交集(结果集)储存到 destination 。
     * 默认情况下，结果集中某个成员的 score 值是所有给定集下该成员 score 值之和.
     * 关于 weights 和 aggregate 选项的描述，参见 zunionstore 命令。
     *
     * 可用版本: >= 2.0.0
     * 时间复杂度: O(N*K)+O(M*log(M))， N 为给定 key 中基数最小的有序集， K 为给定有序集的数量， M 为结果集的基数。
     * 返回值: 保存到 destination 的结果集的基数。
     *
     * @param  String dstkey
     * @param  ZParams params
     * @param  String... sets
     * @return Long
     * */
    public Long zinterstore(String dstkey, ZParams params, String... sets);

    /**
     * zscan key cursor [match pattern] [count count]
     * 详细信息请参考 SCAN 命令。
     *
     * @param  byte[] key
     * @param  byte[] cursor
     * @return ScanResult<Tuple>
     * */
    public ScanResult<Tuple> zscan(byte[] key, byte[] cursor);

    /**
     * zscan key cursor [match pattern] [count count]
     * 详细信息请参考 SCAN 命令。
     *
     * @param  String key
     * @param  int cursor
     * @return ScanResult<Tuple>
     * */
    @Deprecated
    public ScanResult<Tuple> zscan(String key, int cursor);

    /**
     * zscan key cursor [match pattern] [count count]
     * 详细信息请参考 SCAN 命令。
     *
     * @param  String key
     * @param  String cursor
     * @return ScanResult<Tuple>
     * */
    public ScanResult<Tuple> zscan(String key, String cursor);

    /**
     * zscan key cursor [match pattern] [count count]
     * 详细信息请参考 SCAN 命令。
     *
     * @param  byte[] key
     * @param  byte[] cursor
     * @param  ScanParams params
     * @return ScanResult<Tuple>
     * */
    public ScanResult<Tuple> zscan(byte[] key, byte[] cursor, ScanParams params);

    /**
     * zscan key cursor [match pattern] [count count]
     * 详细信息请参考 SCAN 命令。
     *
     * @param  String key
     * @param  int cursor
     * @param  ScanParams params
     * @return ScanResult<Tuple>
     * */
    @Deprecated
    public ScanResult<Tuple> zscan(String key, int cursor, ScanParams params);

    /**
     * zscan key cursor [match pattern] [count count]
     * 详细信息请参考 SCAN 命令。
     *
     * @param  String key
     * @param  String cursor
     * @param  ScanParams params
     * @return ScanResult<Tuple>
     * */
    public ScanResult<Tuple> zscan(String key, String cursor, ScanParams params);
}
