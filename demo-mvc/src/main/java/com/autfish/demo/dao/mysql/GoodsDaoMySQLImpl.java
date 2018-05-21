package com.autfish.demo.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.autfish.demo.dao.BaseDao;
import com.autfish.demo.dao.GoodsDao;
import com.autfish.demo.domain.Goods;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.incrementer.MySQLMaxValueIncrementer;

public class GoodsDaoMySQLImpl extends BaseDao implements GoodsDao {

	private JdbcTemplate jdbcTemplate;
	private MySQLMaxValueIncrementer incrementer;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public MySQLMaxValueIncrementer getIncrementer() {
		return incrementer;
	}

	public void setIncrementer(MySQLMaxValueIncrementer incrementer) {
		this.incrementer = incrementer;
	}

	public GoodsDaoMySQLImpl() {
	}
	
	@Override
	public int matches(int goodsId, String goodsName, float fromPrice,
			float toPrice) {
		List<Object> paramList = new ArrayList<>();
		List<Integer> typesList = new ArrayList<>();
		StringBuilder sql = new StringBuilder().append("SELECT COUNT(1) FROM t_goods WHERE 1=1");
		if(goodsId > 0) {
			sql.append(" AND goods_id=?");
			paramList.add(goodsId);
			typesList.add(Types.INTEGER);
		}
		if(StringUtils.isNotBlank(goodsName)) {
			sql.append(" AND locate(?,goods_name)>0");
			paramList.add(goodsName);
			typesList.add(Types.VARCHAR);
		}
		if(fromPrice > -1) {
			sql.append(" AND goods_price>=?");
			paramList.add(fromPrice);
			typesList.add(Types.FLOAT);
		}
		if(toPrice > -1) {
			sql.append(" AND goods_price<=?");
			paramList.add(toPrice);
			typesList.add(Types.FLOAT);
		}
		int[] types = ArrayUtils.toPrimitive(typesList.toArray(new Integer[0]));
		return jdbcTemplate.queryForObject(sql.toString(), paramList.toArray(), types, Integer.class);
	}
	
	@Override
	public Goods getGoodsById(int goodsId) {
		String sql = "SELECT goods_name,goods_price FROM t_goods WHERE goods_id=?";
		final Goods model = new Goods();
		jdbcTemplate.query(sql, new Object[]{ goodsId }, new int[]{ Types.INTEGER }, new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				model.setId(goodsId);
				model.setName(rs.getString("goods_name"));
				model.setPrice(rs.getFloat("goods_price"));
			}
		});
		return model.getId() > 0 ? model : null;
	}

	@Override
	public List<Goods> findGoods(int goodsId, String goodsName,
			float fromPrice, float toPrice, int fetchIndex, int fetchCount) {
		List<Object> paramList = new ArrayList<>();
		List<Integer> typesList = new ArrayList<>();
		StringBuilder sql = new StringBuilder().append("SELECT * FROM t_goods WHERE 1=1");
		if(goodsId > 0) {
			sql.append(" AND goods_id=?");
			paramList.add(goodsId);
			typesList.add(Types.INTEGER);
		}
		if(StringUtils.isNotBlank(goodsName)) {
			sql.append(" AND locate(?,goods_name)>0");
			paramList.add(goodsName);
			typesList.add(Types.VARCHAR);
		}
		if(fromPrice > -1) {
			sql.append(" AND goods_price>=?");
			paramList.add(fromPrice);
			typesList.add(Types.FLOAT);
		}
		if(toPrice > -1) {
			sql.append(" AND goods_price<=?");
			paramList.add(toPrice);
			typesList.add(Types.FLOAT);
		}
		sql.append(" ORDER BY goods_id DESC").append(" LIMIT ").append(fetchIndex).append(",").append(fetchCount);
		int[] types = ArrayUtils.toPrimitive(typesList.toArray(new Integer[0]));
		final List<Goods> goodsList = new ArrayList<>();
		jdbcTemplate.query(sql.toString(), paramList.toArray(), types, new RowCallbackHandler() {

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				Goods goods = new Goods();
				goods.setId(rs.getInt("goods_id"));
				goods.setName(rs.getString("goods_name"));
				goods.setPrice(rs.getFloat("goods_price"));
				goodsList.add(goods);
			}
		});
		return goodsList;
	}
	
	@Override
	public int addGoods(Goods goods) {
		String sql = "insert into t_goods(goods_id,goods_name,goods_price) values(?, ?, ?)";
		return jdbcTemplate.update(sql, new Object[] { incrementer.nextIntValue(), goods.getName(), goods.getPrice() }, new int[] { Types.INTEGER, Types.VARCHAR, Types.FLOAT });
	}

	@Override
	public int updateGoods(Goods goods) {
		String sql = "update t_goods set goods_name=?,goods_price=? where goods_id=?";
		return jdbcTemplate.update(sql, new Object[] { goods.getName(), goods.getPrice(), goods.getId() }, new int[] { Types.VARCHAR, Types.FLOAT, Types.INTEGER });
	}
	
	@Override
	public int deleteGoods(int goodsId) {
		String sql = "delete from t_goods where goods_id=?";
		return jdbcTemplate.update(sql, new Object[] { goodsId }, new int[] { Types.INTEGER });
	}

	@Override
	public void createTable() {
		String sql = "CREATE TABLE t_goods(goods_id int not null,goods_name varchar(50),goods_price float,PRIMARY KEY(goods_id)) default charset=utf8;";
		jdbcTemplate.execute(sql);
	}

	@Override
	public void createIdTable() {
		String sql = "create table t_goods_id(seq_id int) ENGINE=MYISAM";
		jdbcTemplate.execute(sql);
		sql = "insert into t_goods_id(seq_id) values(0)";
		jdbcTemplate.execute(sql);
	}

	@Override
	public void dropTable() {
		String sql = "drop table t_goods";
		jdbcTemplate.execute(sql);
	}

	@Override
	public void addRandomGoods() {
		String[] prefix = new String[] { "新鲜的", "腐烂的", "进口的", "转基因的", "甜甜的", "苦涩的", "红色的", "黄色的", "绿色的", "紫色的"};
		String[] suffix = new String[] { "苹果", "香蕉", "橘子", "菠萝", "西瓜", "橙子", "萝卜", "白菜", "茄子", "黄瓜"};
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Random rand = new Random();
		int pi = rand.nextInt(10);
		int si = rand.nextInt(10);
		String goodsName = prefix[pi] + suffix[si];
		float goodsPrice = rand.nextFloat() * 1000;
		String sql = "insert into t_goods(goods_id,goods_name,goods_price) values(?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] { incrementer.nextIntValue(), goodsName, goodsPrice }, new int[] { Types.INTEGER, Types.VARCHAR, Types.FLOAT });
	}
	
	@Override
	public void deleteAll() {
		String sql = "delete from t_goods";
		jdbcTemplate.execute(sql);
	}
}
