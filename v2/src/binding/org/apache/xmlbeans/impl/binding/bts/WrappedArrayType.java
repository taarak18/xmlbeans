/*   Copyright 2004 The Apache Software Foundation
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.xmlbeans.impl.binding.bts;

import javax.xml.namespace.QName;

/**
 * A binding of a simple user-defined type that operates by
 * delegating to another well-known (e.g., builtin) binding.
 */
public class WrappedArrayType extends BindingType
{

    // ========================================================================
    // Variables

    private QName itemName;
    private BindingTypeName itemType;
    private boolean nillable;

    // ========================================================================
    // Constructors

    public WrappedArrayType(BindingTypeName btName)
    {
        super(btName);
    }

    public WrappedArrayType(org.apache.xml.xmlbeans.bindingConfig.BindingType node)
    {
        this((org.apache.xml.xmlbeans.bindingConfig.WrappedArray)node);
    }

    public WrappedArrayType(org.apache.xml.xmlbeans.bindingConfig.WrappedArray node)
    {
        super(node);
        this.itemName = node.getItemName();

        final org.apache.xml.xmlbeans.bindingConfig.Mapping itype =
            node.getItemType();
        final JavaTypeName jName = JavaTypeName.forString(itype.getJavatype());
        final XmlTypeName xName = XmlTypeName.forString(itype.getXmlcomponent());
        this.itemType = BindingTypeName.forPair(jName, xName);

        nillable = node.getNillable();
    }


    protected org.apache.xml.xmlbeans.bindingConfig.BindingType write(org.apache.xml.xmlbeans.bindingConfig.BindingType node)
    {
        final org.apache.xml.xmlbeans.bindingConfig.WrappedArray wa =
            (org.apache.xml.xmlbeans.bindingConfig.WrappedArray)super.write(node);

        wa.setItemName(itemName);

        final org.apache.xml.xmlbeans.bindingConfig.Mapping mapping =
            wa.addNewItemType();
        mapping.setJavatype(itemType.getJavaName().toString());
        mapping.setXmlcomponent(itemType.getXmlName().toString());

        wa.setNillable(nillable);
        
        return wa;
    }


    // ========================================================================
    // Public methods
    public QName getItemName()
    {
        return itemName;
    }

    public void setItemName(QName itemName)
    {
        this.itemName = itemName;
    }

    public BindingTypeName getItemType()
    {
        return itemType;
    }

    public void setItemType(BindingTypeName itemType)
    {
        this.itemType = itemType;
    }

    public boolean isNillable()
    {
        return nillable;
    }

    public void setNillable(boolean nillable)
    {
        this.nillable = nillable;
    }

}