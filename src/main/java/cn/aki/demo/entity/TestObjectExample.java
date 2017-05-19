package cn.aki.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class TestObjectExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table test_object
	 * @mbg.generated  Thu May 11 15:24:11 CST 2017
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table test_object
	 * @mbg.generated  Thu May 11 15:24:11 CST 2017
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table test_object
	 * @mbg.generated  Thu May 11 15:24:11 CST 2017
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_object
	 * @mbg.generated  Thu May 11 15:24:11 CST 2017
	 */
	public TestObjectExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_object
	 * @mbg.generated  Thu May 11 15:24:11 CST 2017
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_object
	 * @mbg.generated  Thu May 11 15:24:11 CST 2017
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_object
	 * @mbg.generated  Thu May 11 15:24:11 CST 2017
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_object
	 * @mbg.generated  Thu May 11 15:24:11 CST 2017
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_object
	 * @mbg.generated  Thu May 11 15:24:11 CST 2017
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_object
	 * @mbg.generated  Thu May 11 15:24:11 CST 2017
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_object
	 * @mbg.generated  Thu May 11 15:24:11 CST 2017
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_object
	 * @mbg.generated  Thu May 11 15:24:11 CST 2017
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_object
	 * @mbg.generated  Thu May 11 15:24:11 CST 2017
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table test_object
	 * @mbg.generated  Thu May 11 15:24:11 CST 2017
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table test_object
	 * @mbg.generated  Thu May 11 15:24:11 CST 2017
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Long value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andVarcharValueIsNull() {
			addCriterion("varchar_value is null");
			return (Criteria) this;
		}

		public Criteria andVarcharValueIsNotNull() {
			addCriterion("varchar_value is not null");
			return (Criteria) this;
		}

		public Criteria andVarcharValueEqualTo(String value) {
			addCriterion("varchar_value =", value, "varcharValue");
			return (Criteria) this;
		}

		public Criteria andVarcharValueNotEqualTo(String value) {
			addCriterion("varchar_value <>", value, "varcharValue");
			return (Criteria) this;
		}

		public Criteria andVarcharValueGreaterThan(String value) {
			addCriterion("varchar_value >", value, "varcharValue");
			return (Criteria) this;
		}

		public Criteria andVarcharValueGreaterThanOrEqualTo(String value) {
			addCriterion("varchar_value >=", value, "varcharValue");
			return (Criteria) this;
		}

		public Criteria andVarcharValueLessThan(String value) {
			addCriterion("varchar_value <", value, "varcharValue");
			return (Criteria) this;
		}

		public Criteria andVarcharValueLessThanOrEqualTo(String value) {
			addCriterion("varchar_value <=", value, "varcharValue");
			return (Criteria) this;
		}

		public Criteria andVarcharValueLike(String value) {
			addCriterion("varchar_value like", value, "varcharValue");
			return (Criteria) this;
		}

		public Criteria andVarcharValueNotLike(String value) {
			addCriterion("varchar_value not like", value, "varcharValue");
			return (Criteria) this;
		}

		public Criteria andVarcharValueIn(List<String> values) {
			addCriterion("varchar_value in", values, "varcharValue");
			return (Criteria) this;
		}

		public Criteria andVarcharValueNotIn(List<String> values) {
			addCriterion("varchar_value not in", values, "varcharValue");
			return (Criteria) this;
		}

		public Criteria andVarcharValueBetween(String value1, String value2) {
			addCriterion("varchar_value between", value1, value2, "varcharValue");
			return (Criteria) this;
		}

		public Criteria andVarcharValueNotBetween(String value1, String value2) {
			addCriterion("varchar_value not between", value1, value2, "varcharValue");
			return (Criteria) this;
		}

		public Criteria andBooleanValueIsNull() {
			addCriterion("boolean_value is null");
			return (Criteria) this;
		}

		public Criteria andBooleanValueIsNotNull() {
			addCriterion("boolean_value is not null");
			return (Criteria) this;
		}

		public Criteria andBooleanValueEqualTo(Boolean value) {
			addCriterion("boolean_value =", value, "booleanValue");
			return (Criteria) this;
		}

		public Criteria andBooleanValueNotEqualTo(Boolean value) {
			addCriterion("boolean_value <>", value, "booleanValue");
			return (Criteria) this;
		}

		public Criteria andBooleanValueGreaterThan(Boolean value) {
			addCriterion("boolean_value >", value, "booleanValue");
			return (Criteria) this;
		}

		public Criteria andBooleanValueGreaterThanOrEqualTo(Boolean value) {
			addCriterion("boolean_value >=", value, "booleanValue");
			return (Criteria) this;
		}

		public Criteria andBooleanValueLessThan(Boolean value) {
			addCriterion("boolean_value <", value, "booleanValue");
			return (Criteria) this;
		}

		public Criteria andBooleanValueLessThanOrEqualTo(Boolean value) {
			addCriterion("boolean_value <=", value, "booleanValue");
			return (Criteria) this;
		}

		public Criteria andBooleanValueIn(List<Boolean> values) {
			addCriterion("boolean_value in", values, "booleanValue");
			return (Criteria) this;
		}

		public Criteria andBooleanValueNotIn(List<Boolean> values) {
			addCriterion("boolean_value not in", values, "booleanValue");
			return (Criteria) this;
		}

		public Criteria andBooleanValueBetween(Boolean value1, Boolean value2) {
			addCriterion("boolean_value between", value1, value2, "booleanValue");
			return (Criteria) this;
		}

		public Criteria andBooleanValueNotBetween(Boolean value1, Boolean value2) {
			addCriterion("boolean_value not between", value1, value2, "booleanValue");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table test_object
	 * @mbg.generated  Thu May 11 15:24:11 CST 2017
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table test_object
     *
     * @mbg.generated do_not_delete_during_merge Thu May 11 15:15:38 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}