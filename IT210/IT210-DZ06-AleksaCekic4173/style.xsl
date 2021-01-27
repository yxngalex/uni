<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
    <html>
      <body>
          <!-- Primer 1 -->
          <h2>Studenti</h2>
          <table border="1">
            <tr bgcolor="#FF5733">
                <th>Ime</th>
                <th>Prezime</th>
                <th>Starost</th>
                <th>Ocena IT210</th>
            </tr>
             <xsl:for-each select="studenti/student[starost>21 or ocena1>5]">
                    <tr>
                        <td><xsl:value-of select="ime"/></td>
                        <td><xsl:value-of select="prezime"/></td>
                        <td><xsl:value-of select="starost"/></td>
                        <td><xsl:value-of select="ispiti/predmet1/ocena1"/></td>
                    </tr>
              </xsl:for-each>
              </table>

            <!-- Primer 2 -->
            <h2>Najmladji Student</h2>
            <xsl:for-each select="studenti/student">
                <xsl:sort select="starost" data-type="number" order="ascending"/>
                <xsl:if test="position() = 1">
                  Najmladji Student: <xsl:apply-templates/>
                </xsl:if>
            </xsl:for-each>

          <!-- Primer 3 -->
          <h2>Najstariji Student</h2>
          <xsl:for-each select="studenti/student">
              <xsl:sort select="starost" data-type="number" order="ascending"/>
              <xsl:if test="position() = last()">
                Najstariji Student: <xsl:apply-templates/>
              </xsl:if>
          </xsl:for-each>
      </body>
    </html>
</xsl:template>
</xsl:stylesheet>
