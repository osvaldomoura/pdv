/*
 Copyright  2005 MySQL AB, 2008 Sun Microsystems
 All rights reserved. Use is subject to license terms.

  The MySQL Connector/J is licensed under the terms of the GPL,
  like most MySQL Connectors. There are special exceptions to the
  terms and conditions of the GPL as it is applied to this software,
  see the FLOSS License Exception available on mysql.com.

  This program is free software; you can redistribute it and/or
  modify it under the terms of the GNU General Public License as
  published by the Free Software Foundation; version 2 of the
  License.

  This program is distributed in the hope that it will be useful,  
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU General Public License for more details.

  You should have received a copy of the GNU General Public License
  along with this program; if not, write to the Free Software
  Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
  02110-1301 USA

*/

package com.mysql.jdbc.jdbc2.optional;

import javax.transaction.xa.Xid;

/**
 * Implementation of the XID interface for MySQL XA
 * 
 * @version $Id: $
 */
public class MysqlXid implements Xid {

	int hash = 0;

	byte[] myBqual;

	int myFormatId;

	byte[] myGtrid;

	public MysqlXid(byte[] gtrid, byte[] bqual, int formatId) {
		this.myGtrid = gtrid;
		this.myBqual = bqual;
		this.myFormatId = formatId;
	}

	public boolean equals(Object another) {

		if (another instanceof Xid) {
			Xid anotherAsXid = (Xid) another;

			if (this.myFormatId != anotherAsXid.getFormatId()) {
				return false;
			}

			byte[] otherBqual = anotherAsXid.getBranchQualifier();
			byte[] otherGtrid = anotherAsXid.getGlobalTransactionId();

			if (otherGtrid != null && otherGtrid.length == this.myGtrid.length) {
				int length = otherGtrid.length;

				for (int i = 0; i < length; i++) {
					if (otherGtrid[i] != this.myGtrid[i]) {
						return false;
					}
				}

				if (otherBqual != null && otherBqual.length == myBqual.length) {
					length = otherBqual.length;

					for (int i = 0; i < length; i++) {
						if (otherBqual[i] != this.myBqual[i]) {
							return false;
						}
					}
				} else {
					return false;
				}

				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public byte[] getBranchQualifier() {
		return this.myBqual;
	}

	public int getFormatId() {
		return this.myFormatId;
	};

	public byte[] getGlobalTransactionId() {
		return this.myGtrid;
	}

	public synchronized int hashCode() {
		if (this.hash == 0) {
			for (int i = 0; i < this.myGtrid.length; i++) {
				this.hash = 33 * this.hash + this.myGtrid[i];
			}
		}

		return this.hash;
	}
}
