<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0" xmlns:fo="http://www.w3.org/1999/XSL/Format">
	<xsl:template match="/">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">


			<!-- defines the layout master -->
			<fo:layout-master-set>
				<fo:simple-page-master master-name="first"
					page-height="29.7cm" page-width="21cm" margin-top="1cm"
					margin-bottom="2cm" margin-left="2.5cm" margin-right="2.5cm">
					<fo:region-body margin-top="3cm" />
					<fo:region-before extent="3cm" />
					<fo:region-after extent="1.5cm" />
				</fo:simple-page-master>
			</fo:layout-master-set>

			<!-- starts actual layout -->
			<fo:page-sequence master-reference="first">

				<fo:flow flow-name="xsl-region-body">

					<fo:table table-layout="fixed" width="100%"
						border-collapse="separate" border-width="1pt" border-style="solid">
						<fo:table-column column-width="30mm" />
						<fo:table-column column-width="30mm" />
						<fo:table-column column-width="30mm" />
						<fo:table-body>
							<fo:table-row border-width="1pt" border-style="solid">
								<fo:table-cell border-width="1pt" border-style="solid">
									<fo:block>good</fo:block>
								</fo:table-cell>
								<fo:table-cell border-width="1pt" border-style="solid">
									<fo:block>bad</fo:block>
								</fo:table-cell>
								<fo:table-cell border-width="1pt" border-style="solid">
									<fo:block>ugly</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row border-width="1pt" border-style="solid">
								<fo:table-cell border-width="1pt" border-style="solid">
									<fo:block>nice</fo:block>
								</fo:table-cell>
								<fo:table-cell border-width="1pt" border-style="solid">
									<fo:block>dice</fo:block>
								</fo:table-cell>
								<fo:table-cell border-width="1pt" border-style="solid">
									<fo:block>vice</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row border-width="1pt" border-style="solid">
								<fo:table-cell border-width="1pt" border-style="solid">
									<fo:block>literature</fo:block>
								</fo:table-cell>
								<fo:table-cell border-width="1pt" border-style="solid">
									<fo:block>music</fo:block>
								</fo:table-cell>
								<fo:table-cell border-width="1pt" border-style="solid">
									<fo:block>art</fo:block>
								</fo:table-cell>
							</fo:table-row>
							<fo:table-row border-width="1pt" border-style="solid">
								<fo:table-cell border-width="1pt" border-style="solid">
									<fo:block height="20pt" width="20pt">
										<fo:instream-foreign-object height="20pt" width="20pt" content-height="scale-up-to-fit" content-width="scale-up-to-fit" overflow="visible" xmlns:svg="http://www.w3.org/2000/svg">
										<svg xmlns="http://www.w3.org/2000/svg" version="1.1">
											<!-- <line x1="0" y1="-1" x2="82" y2="100" style="stroke:black;stroke-width:2;" stroke-linejoin="miter" /> -->
											 <polyline points="0,0 83,24" style="fill:none;stroke:black;stroke-width:1.2" />
										</svg>
										</fo:instream-foreign-object>
									</fo:block>
								</fo:table-cell>
								<fo:table-cell border-width="1pt" border-style="solid">
									<fo:block>perl</fo:block>
								</fo:table-cell>
								<fo:table-cell border-width="1pt" border-style="solid">
									<fo:block>python</fo:block>
								</fo:table-cell>
							</fo:table-row>
						</fo:table-body>
					</fo:table>
					<!-- table end -->
					
				</fo:flow>
			</fo:page-sequence>
		</fo:root>

	</xsl:template>
</xsl:stylesheet>