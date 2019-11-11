/**
 * This class is generated by jOOQ
 */
package com.lanzonprojects.omsapi.jooq.generated.tables;


import com.lanzonprojects.omsapi.jooq.generated.DogboxOms;
import com.lanzonprojects.omsapi.jooq.generated.Keys;
import com.lanzonprojects.omsapi.jooq.generated.tables.records.AttributesRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.3"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Attributes extends TableImpl<AttributesRecord> {

	private static final long serialVersionUID = -1496444031;

	/**
	 * The reference instance of <code>dogbox_oms.attributes</code>
	 */
	public static final Attributes ATTRIBUTES = new Attributes();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<AttributesRecord> getRecordType() {
		return AttributesRecord.class;
	}

	/**
	 * The column <code>dogbox_oms.attributes.id</code>.
	 */
	public final TableField<AttributesRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>dogbox_oms.attributes.NAME</code>.
	 */
	public final TableField<AttributesRecord, String> NAME = createField("NAME", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

	/**
	 * Create a <code>dogbox_oms.attributes</code> table reference
	 */
	public Attributes() {
		this("attributes", null);
	}

	/**
	 * Create an aliased <code>dogbox_oms.attributes</code> table reference
	 */
	public Attributes(String alias) {
		this(alias, ATTRIBUTES);
	}

	private Attributes(String alias, Table<AttributesRecord> aliased) {
		this(alias, aliased, null);
	}

	private Attributes(String alias, Table<AttributesRecord> aliased, Field<?>[] parameters) {
		super(alias, DogboxOms.DOGBOX_OMS, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<AttributesRecord, Integer> getIdentity() {
		return Keys.IDENTITY_ATTRIBUTES;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<AttributesRecord> getPrimaryKey() {
		return Keys.KEY_ATTRIBUTES_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<AttributesRecord>> getKeys() {
		return Arrays.<UniqueKey<AttributesRecord>>asList(Keys.KEY_ATTRIBUTES_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Attributes as(String alias) {
		return new Attributes(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Attributes rename(String name) {
		return new Attributes(name, null);
	}
}