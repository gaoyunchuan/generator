package org.mybatis.generator.plugins.paginator;

/**
 * Created by gaoyunchuan on 15/12/28.
 */
public class Page {

    // 分页查询开始记录位置
    private int begin;
    // 分页查看下结束位置
    private int end;
    // 每页显示记录数
    private int length;
    // 查询结果总记录数
    private int count;
    // 当前页码
    private int current;
    // 总共页数
    private int total;

    public Page() {
    }

    /**
     * 构造函数
     *
     * @param current
     * @param length
     */
    public Page(int current, int length) {
        this.begin = (current - 1) * length;
        this.length = length;
        this.end = this.begin + this.length;
        this.current = current;
    }

    /**
     * @param current
     * @param length
     * @param count
     */
    public Page(int current, int length, int count) {
        this(current, length);
        this.count = count;
    }

    /**
     * @return the begin
     */
    public int getBegin() {
        return begin;
    }

    /**
     * @return the end
     */
    public int getEnd() {
        return end;
    }

    /**
     * @param end
     *            the end to set
     */
    public void setEnd(int end) {
        this.end = end;
    }

    /**
     * @param begin
     *            the begin to set
     */
    public void setBegin(int begin) {
        this.begin = begin;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length
     *            the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count
     *            the count to set
     */
    public void setCount(int count) {
        this.count = count;
        this.total = (int) Math.floor((this.count * 1.0d) / this.length);
        if (this.count % this.length != 0) {
            this.total++;
        }
    }

    /**
     * @return the current
     */
    public int getCurrent() {
        return current;
    }

    /**
     * @param current
     *            the current to set
     */
    public void setCurrent(int current) {
        this.current = current;
        if (this.current != 0){
            this.begin = (this.current - 1) * length;
        }
    }

    /**
     * @return the total
     */
    public int getTotal() {
        if (total == 0) {
            return 1;
        }
        return total;
    }

    /**
     * @param total
     *            the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }
}
